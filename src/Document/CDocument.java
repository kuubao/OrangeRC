package Document;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFileChooser;
/**
 * ѧ�������ļ�
 * @author Administrator
 *
 */
public class CDocument {
	private Socket socket;
	public CDocument(){
		this.SendDocument();
	}
	//�����ļ�
	private void SendDocument() {
		try {
//			while (true) {
				socket=new Socket("127.0.0.1",8822);
				// ѡ����д�����ļ�
				// �����ļ�ѡ����
				JFileChooser jf = new JFileChooser();
				//��ʱ��ʾ�ļ���Ŀ¼
				jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				//���������ļ���ѡ���            	
				jf.showOpenDialog(null);
				//����ѡ�е��ļ�            	
				String filePath = jf.getSelectedFile().getPath();

				File fi = new File(filePath);
				System.out.println("�ļ����ȣ�" + (int) fi.length());
				// public Socket accept() throws
				// IOException���������ܵ����׽��ֵ����ӡ��˷����ڽ�������֮ǰһֱ������
				/* DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
               dis.readByte();
				 */
				DataInputStream fis = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
				DataOutputStream ps = new DataOutputStream(socket.getOutputStream());
				//���ļ��������ȴ����ͻ��ˡ�����Ҫ������������ƽ̨�������������Ĵ�������Ҫ�ӹ���������Բμ�Think In Java 4th�����ֳɵĴ��롣
				ps.writeUTF(fi.getName());
				System.out.println(fi.getName());
				ps.flush();
				int bufferSize = 8192;
				byte[] buf = new byte[bufferSize];
				while (true) {
					int read = 0;
					if (fis != null) {
						read = fis.read(buf);
					}
					if (read == -1) {
						break;
					}
					ps.write(buf, 0, read);
				}
				ps.flush();
				// ע��ر�socket����Ŷ����Ȼ�ͻ��˻�ȴ�server�����ݹ�����
				// ֱ��socket��ʱ���������ݲ�������                
				fis.close();
				socket.close();                
				System.out.println("�ļ��������");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		new CDocument();
	}
}
