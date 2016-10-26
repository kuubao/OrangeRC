package Listener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import Server.RemoteServer;
import ServerUI.BigScreen;

/**
 * 每个客户端界面按钮的监听
 * 双击可放大监控客户端的界面
 * @author MIKORU
 * @date 2016.09.28
 */
public class CMouseListener extends RMouseListener {
	@SuppressWarnings("unused")
	private int order;
	public CMouseListener(int order) {
		// TODO Auto-generated constructor stub
		super();
		this.order = order;
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String btnName =((JButton)e.getSource()).getText();
		if(e.getClickCount()==2){
			if(RMouseListener.cl==true){
				new BigScreen(RemoteServer.ip);
			}
		}
	}
}
