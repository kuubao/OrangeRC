package ServerUI;

import java.awt.*;  

import javax.swing.JPanel;  
  
/***
 * 用于实现背景面板使用自定义图像
 * @author MIKORU
 *
 */
@SuppressWarnings("serial")
public class BackgroundPane extends JPanel {  
      
    private Image image = null;
  
    public BackgroundPane(Image image) {  
        this.image = image;  
    }  
  
    protected void paintComponent(Graphics g) {  
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
    }  
}  