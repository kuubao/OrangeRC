import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicButtonUI;


@SuppressWarnings("serial")
public class GUI extends JFrame{
	private JButton controlBtn = null;
	private JButton docuBtn = null;
	private JButton screenBtn = null;
	private JButton playBtn = null;
	private final static int USERNUM = RemoteServer.USERNUM; 
	public static JButton[] la_image  = new JButton[USERNUM];
	
	public GUI(){
		display();
	}
	
	private JPanel addJPanel() {
		JPanel menuPanel = new BackgroundPane(new ImageIcon("./image/menubb.jpg").getImage());
		//JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		controlBtn = createBtn("控制屏幕", "./image/control64.png",150,140);
		menuPanel.add(controlBtn);
		//controlBtn.addMouseListener(new RMouseListener());

		docuBtn = createBtn("文件传输","./image/document64.png",150,140);
		menuPanel.add(docuBtn);
		//docuBtn.addMouseListener(new RMouseListener());
		
		screenBtn = createBtn("屏幕演示", "./image/computer64.png",150,140);
		menuPanel.add(screenBtn);
		//screenBtn.addMouseListener(new RMouseListener());
		
		playBtn = createBtn("关机重启", "./image/shutdown64.png",150,140);
		menuPanel.add(playBtn);
		//playBtn.addMouseListener(new RMouseListener());
		
		return menuPanel;
	}

	private JButton createBtn(String text, String icon,int w,int h) {
		JButton btn = new JButton(text, new ImageIcon(icon));
		btn.setUI(new BasicButtonUI());// 恢复基本视觉效果
		btn.setPreferredSize(new Dimension(w, h));// 设置按钮大小
		btn.setContentAreaFilled(false);// 设置按钮透明
		btn.setFont(new Font("黑体", Font.PLAIN, 25));// 按钮文本样式
		btn.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.addMouseListener(new RMouseListener());
		btn.setIconTextGap(15);
		return btn;
	}
	private void display(){
		
		this.setSize(1310, 730);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("OrangeRC");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		JLabel jls = new JLabel(new ImageIcon("./image/menub.jpg"));
	  	jls.setBounds(0, 0, 1300,120);
		
		JPanel jlp = new BackgroundPane(new ImageIcon("./image/background.jpg").getImage());
		jlp.setLayout(new GridLayout(USERNUM/3+1,3,5,5));
		
		for(int i=0;i<USERNUM;i++){
		    la_image[i] = createBtn("主机 "+i,"./image/huaji.png",300,250);
		    jlp.add(la_image[i]);
		    la_image[i].addMouseListener(new CMouseListener(i));
		    //la_image[i].setOpaque(true);
		}
		
	    JPanel menuPanel = addJPanel();
	  	menuPanel.setBounds(0,120,150, 580);
	  	menuPanel.setBorder(BorderFactory.createMatteBorder(15, 1, 1, 1, Color.white));

	  	JScrollPane scroll = new JScrollPane(jlp);
	  	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	  	scroll.setBorder(BorderFactory.createTitledBorder("屏幕分享"));
	  	scroll.setBounds(150,120,1150, 580);
	  	scroll.setBackground(Color.white);
	  	this.getContentPane().add(menuPanel);
	  	this.getContentPane().add(jls);
	    this.getContentPane().add(scroll);
	    this.getContentPane().setBackground(Color.white);
	}
}
