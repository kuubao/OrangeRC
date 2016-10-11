import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RemoteClient {  
	  
	JLabel la_image= new JLabel();
	private JPanel contentPane;
    Socket socket;  
    ObjectInputStream ins;
    
    
    public static void main(String[] args) {
	        Socket socket = null;  
	        try {  
	            socket = new Socket("127.0.0.1", 1123);  
	        } catch (UnknownHostException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } 
	        //System.out.println("dsuad;onsaju");
	        new RemoteClient(socket);
    }

    public RemoteClient(Socket socket) {  
        this.socket = socket;  
        try {  
            ins = new ObjectInputStream(socket.getInputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        //new Login();
        new GUI(la_image);
        new Receive().run(la_image,ins);
    }   
}  