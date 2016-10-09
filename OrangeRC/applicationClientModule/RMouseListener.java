import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class RMouseListener implements MouseListener {

	private GUI frame;

	public RMouseListener() {
		// TODO Auto-generated constructor stub
	}

	public RMouseListener(GUI f) {
		this.frame = f;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String btnName =((JButton)e.getSource()).getText();
		if ("File".equals(btnName.trim())) {
			//Êó±êµã»÷ÊÂ¼ş
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		Border etchedBorder = new EtchedBorder(EtchedBorder.RAISED);// ÉèÖÃ±ß¿òÍ¹ÏÔ
		btn.setBorder(etchedBorder);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ÉèÖÃ±ß¿ò°¼ÏÔ
		btn.setBorder(etchedBorder);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		btn.setForeground(new Color(0x33, 0x66, 0xcc));// ÉèÖÃ×ÖÌåÑÕÉ«
		btn.setBorderPainted(true);// ÏÔÊ¾±ß¿ò
		Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ÉèÖÃ±ß¿ò°¼ÏÔ
		btn.setBorder(etchedBorder);
		btn.setRolloverEnabled(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		btn.setForeground(Color.black);// ÉèÖÃ×ÖÌåÑÕÉ«
		btn.setBorderPainted(false);// Òş²Ø±ß¿ò
	}

}