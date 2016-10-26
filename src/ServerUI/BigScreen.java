package ServerUI;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * 
 * 开放端口1234，建立控制屏幕功能的监听
 * 放大屏幕，达成控制客户端屏幕的效果
 * 
 * @author MIKORU
 * @date 2016.10.26
 * 
 */

@SuppressWarnings("serial")
public class BigScreen extends JFrame{
	public static JLabel la = new JLabel();
	public BigScreen(String btnName){
		display(btnName);
	}
	/**
	 * 开放端口1234
	 * 向socket通道中发送信息
	 * 
	 */
	public void sendEvent(InputEvent event) {
		ServerSocket server2;
		try {
			server2 = new ServerSocket(1123);
			Socket socket2;
			socket2 = server2.accept();
			ObjectOutputStream objectOut = null;
			objectOut = new ObjectOutputStream(socket2.getOutputStream());
	        objectOut.writeObject(event);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/**
	 * 界面显示设置
	 * 鼠标键盘事件监听
	 */
	private void display(String title){
		JFrame frame = new JFrame(title);
        Toolkit tool = Toolkit.getDefaultToolkit();  
        Dimension dis = tool.getScreenSize();
		frame.setSize(dis);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		la.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {} 
			public void mousePressed(MouseEvent e) { 
				sendEvent(e); 
            }
			public void mouseReleased(MouseEvent e) { 
                sendEvent(e); 
            }
			public void mouseEntered(MouseEvent e) {} 
			public void mouseExited(MouseEvent e) {} 
        });
		la.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e) { 
                sendEvent(e); 
            }
			public void mouseMoved(MouseEvent e) { 
                sendEvent(e); 
            } 
        });
		//la.setIcon(new ImageIcon(BigScreen.class.getResource("./image/CE.jpg")));
		la.setBounds(0, 0, 1000, 700);
		frame.add(la);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}
}
