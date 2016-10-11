
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.*;

public class Login extends JFrame{
    JTextField jTextField ;
    JPasswordField jPasswordField;
    JLabel jLabel1,jLabel2;
    JPanel jp1,jp2,jp3;
    JButton jb1,jb2;
    private JButton createBtn(String text, String icon) {
		JButton btn = new JButton(text, new ImageIcon(icon));
		btn.setUI(new BasicButtonUI());// 恢复基本视觉效果
		btn.setPreferredSize(new Dimension(100, 40));// 设置按钮大小
		btn.setContentAreaFilled(false);// 设置按钮透明
		btn.setFont(new Font("黑体", Font.PLAIN, 20));// 按钮文本样式
		btn.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
		btn.addMouseListener(new RMouseListener(this));
		return btn;
	}
    @SuppressWarnings("deprecation")
	public Login(){
        jTextField = new JTextField(12);
        jPasswordField = new JPasswordField(12);
        jLabel1 = new JLabel("用户名");
        jLabel2 = new JLabel(" 密码  ");
        jb1 = createBtn("确认","./image/yes.png");
        jb2 = createBtn("取消","./image/cancel.png");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        
        //设置布局
        this.setLayout(new GridLayout(3, 1,0,3));
        
        jp1.add(jLabel1); 
        jp1.add(jTextField);//第一块面板添加用户名和文本框 
        jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        jp2.add(jLabel2);
        jp2.add(jPasswordField);//第二块面板添加密码和密码输入框
        jp2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 12));
        
        jp3.add(jb1);
        jp3.add(jb2); //第三块面板添加确认和取消
        jp3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        //设置显示
        this.setSize(300, 250);
        this.setLocation(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("登陆");
         
    }
}