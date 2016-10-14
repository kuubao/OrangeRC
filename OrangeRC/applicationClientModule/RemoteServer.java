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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.IIOException;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

public class RemoteServer {  
	  
    private static Socket st;
    public static String ip;
    public final static int USERNUM = 56;
    private static int order = 0;
    
    
    public static void main(String[] args) {
    	//new Login();
    	new GUI();
        ServerSocket server;  
        try {  
            server = new ServerSocket(1123);  
            st = server.accept();
            ip = st.getInetAddress().getHostAddress();
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        new Receive(st).start();
    }
    public static int getorder(){
    	String[] ips = new String[USERNUM];
    	for(int i=0;i<order;i++){
    		if(ips[i].equals(ip)){
    			return i;
    		}
    	}
    	ips[order]=ip;
    	order++;
    	return order-1;
    }
}  
  
  
