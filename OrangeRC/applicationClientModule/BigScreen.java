import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class BigScreen extends JFrame{
	public static JLabel la = new JLabel();
	public BigScreen(String btnName){
		display(btnName);
	}
	public void sendEvent(InputEvent event){
		Socket socket = null;
		try {
			socket = new Socket(RemoteServer.ip,1234);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectOutputStream objectOut = null;
		try {
			objectOut = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
            objectOut.writeObject(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	private void display(String title){
		JFrame frame = new JFrame(title);
		frame.setSize(1000, 720);
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
		la.setIcon(new ImageIcon("./image/CE.jpg"));
		la.setBounds(0, 0, 1000, 700);
		frame.add(la);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}
}
