import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/** 
 * 接收客户端的图片 
 *  
 * @author MIKORU
 * @date 2016.09.27
 */  
public class Receive extends Thread {  
		boolean isAlive = true;  
		ImageIcon icon;
		private Socket st;
		private ObjectInputStream ins;
		private static String ip;
		private int s = 0;
		
	    public Receive(Socket st,String ip,int order) {
			this.st = st;
			Receive.ip = ip;
			this.s = order;
		}
		public void run() {
			try {  
	            ins = new ObjectInputStream(st.getInputStream());  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }
                while (isAlive) {
	            	try {
						icon = (ImageIcon) ins.readObject();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	                Image img = icon.getImage();
	                BufferedImage bi = resize(img,300,200);
	                GUI.la_image[s].setIcon(new ImageIcon(bi));
	                GUI.la_image[s].setText(ip);
	                GUI.la_image[s].setVerticalTextPosition(JButton.BOTTOM);
	                GUI.la_image[s].setHorizontalTextPosition(JButton.CENTER);
	                GUI.la_image[s].setIconTextGap(15);
	                try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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