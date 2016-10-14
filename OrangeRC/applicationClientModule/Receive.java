import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/** 
 * 接收服务器的图片 
 *  
 * @author MIKORU
 * @date 2016.09.27
 */  
public class Receive extends Thread {  
		boolean isAlive = true;  
		ImageIcon icon;
		private Socket socket;
		private ObjectInputStream ins;
		private int order;
		
		public Receive(Socket socket) {
			super();
			this.socket = socket;
			order = RemoteServer.getorder();
		}
		@Override
		public void run() {
			try {  
	            ins = new ObjectInputStream(socket.getInputStream());  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }
            try {
                while (isAlive) { 
                	icon = (ImageIcon) ins.readObject();
                	Image img = icon.getImage();
                    BufferedImage bi = resize(img,300,200);
                    GUI.la_image[order].setIcon(new ImageIcon(bi));
                    GUI.la_image[order].setText(RemoteServer.ip);
                    GUI.la_image[order].setVerticalTextPosition(JButton.BOTTOM);
                    GUI.la_image[order].setHorizontalTextPosition(JButton.CENTER);
                    GUI.la_image[order].setIconTextGap(15);
                    Thread.sleep(1000);  
                }  
            } catch (Exception e1) {  
                e1.printStackTrace();  
            }
         }
        private BufferedImage resize(Image img, int newW, int newH) {
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            BufferedImage dimg = new BufferedImage(newW, newH,BufferedImage.TYPE_INT_BGR);
            Graphics2D g = dimg.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                          RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
            g.dispose();
            return dimg;
        }
			
}