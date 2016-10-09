import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.Icon;
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
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.text.html.ImageView;


public class GUI extends JFrame{
	private JButton searchBtn = null;
	private JButton editBtn = null;
	private JButton saveBtn = null;
	
	public GUI(JLabel la_image){
		display(la_image);
	}
	private JPanel addJPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
		// 增加文件选择按钮
		menuPanel.add(createBtn("控制屏幕", "./image/control72x.png"));

		// 增加编辑按钮
		editBtn = createBtn("文件传输","./image/document96x.png");
		//editBtn.setEnabled(false);
		menuPanel.add(editBtn);

		// 增加保存文件按钮
		saveBtn = createBtn("屏幕演示", "./image/screen96x.png");
		//saveBtn.setEnabled(false);
		menuPanel.add(saveBtn);

		// 增加查询输入文本框
//		searchText = new JTextField();
//		searchText.setPreferredSize(new Dimension(140, 27));
//		menuPanel.add(searchText);

		// 增加查询按钮
		searchBtn = createBtn("开始", "./image/play96xn.png");
		//searchBtn.setEnabled(false);
		menuPanel.add(searchBtn);

		return menuPanel;
	}

	/**
	 * 创建工具栏按钮
	 * 
	 * @param text
	 *            按钮名称
	 * @param icon
	 *            按钮图标所在路径
	 * @return 返回添加样式和监听器后的按钮
	 */
	private JButton createBtn(String text, String icon) {
		JButton btn = new JButton(text, new ImageIcon(icon));
		btn.setUI(new BasicButtonUI());// 恢复基本视觉效果
		btn.setPreferredSize(new Dimension(250, 100));// 设置按钮大小
		btn.setContentAreaFilled(false);// 设置按钮透明
		btn.setFont(new Font("黑体", Font.PLAIN, 20));// 按钮文本样式
		btn.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
		btn.addMouseListener(new RMouseListener(this));
		return btn;
	}
	private void display(JLabel la_image){
		
		this.setSize(1320, 750);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("OrangeRC");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    la_image.setSize(300, 200);
	
	    JLayeredPane jlp = new JLayeredPane();  
	    
	    la_image.setBounds(40, 0, la_image.getWidth(),la_image.getHeight());
	    la_image.setOpaque(true);
	    jlp.add(la_image);
	    
	    JPanel menuPanel = addJPanel();
	  	menuPanel.setPreferredSize(new Dimension(140, 150));
	    
	  	this.getContentPane().add(menuPanel,BorderLayout.NORTH);
	    this.getContentPane().add(jlp,BorderLayout.CENTER);
        
	}
}
