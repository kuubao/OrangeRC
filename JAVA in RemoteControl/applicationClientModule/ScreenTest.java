import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
 
import javax.swing.*;
 
public class ScreenTest {
    
    public static void main(String[] args)throws Exception {
    
       JFrame jf = new JFrame("¿ØÖÆÌ¨");

       jf.setSize(500, 400);

       JLabel imag_lab = new JLabel();
       jf.add(imag_lab);

       jf.setVisible(true);

       jf.setAlwaysOnTop(true);

       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       java.awt.Dimension d =jf.size();
       java.awt.Graphics g = jf.getGraphics();
       
       Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
       java.awt.Dimension dm =tk.getScreenSize();
      
       
       java.awt.Robot robot = new java.awt.Robot();
       for (int i = 0; i < 1000; i++) {
          
           Rectangle rec = new Rectangle(0, 0, (int) dm.getWidth(), (int) dm
                  .getHeight());
           BufferedImage bimage = robot.createScreenCapture(rec);
          
           BufferedImage littleImage =resize(bimage,jf.getWidth(),jf
                  .getHeight());
          
           FileOutputStream fous =new FileOutputStream("screenImg¡±+i+¡±.jpeg");
       // javax.imageio.ImageIO.write(littleImage, "jpeg", fous);
           fous.flush();
           fous.close();
           
           imag_lab.setIcon(new javax.swing.ImageIcon(littleImage));
           Thread.sleep(50);
       }
    }
 
   
    private static BufferedImage resize(BufferedImage img,int newW,int newH) {
       int w = img.getWidth();
       int h = img.getHeight();
       BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
       Graphics2D g = dimg.createGraphics();
       g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
              RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h,null);
       g.dispose();
       return dimg;
    }
}