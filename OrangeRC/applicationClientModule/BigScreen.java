import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BigScreen extends JFrame{
	public static JLabel la = new JLabel();
	public BigScreen(String btnName){
		JFrame frame = new JFrame(btnName);
		frame.setSize(1000, 720);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		frame.add(la);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}
}
