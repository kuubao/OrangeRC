import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.IIOException;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

public class RemoteServer {  
	  
    private static Socket st;  
  
    public static void main(String[] args) {  
        ServerSocket server;  
        try {  
            server = new ServerSocket(1123);  
            st = server.accept();   
            // 两个线程，一个发送截屏，一个接收鼠标键盘并进行模拟操作  
            new SendThread(st).start();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
  
  
class SendThread extends Thread {  
    Robot robot;  
    ObjectOutputStream os;  
    BufferedOutputStream bos;  
    ImageOutputStream ios;  
    Rectangle rect;  
    private boolean isAlive = true;  
    Socket st;  
  
    public SendThread(Socket st) {  
        this.st = st;  
        try {
            robot = new Robot();  
            Point p = new Point(0, 0);  
            // 获得屏幕大小  
            Toolkit tool = Toolkit.getDefaultToolkit();  
            Dimension dis = tool.getScreenSize();  
            rect = new Rectangle(p, dis);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void run() {  
        try {  
            os = new ObjectOutputStream(st.getOutputStream());  
            BufferedImage img = null;  
            while (isAlive) {  
                // 根据矩形rect大小进行截屏，得到BUfferedImage对象  
                img = robot.createScreenCapture(rect);  
                // BUfferedImage序列化，先包装成ImageIcon再写出去  
                ImageIcon icon = new ImageIcon(img);  
                os.writeObject(icon);  
                os.flush();  
                Thread.sleep(1000);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  