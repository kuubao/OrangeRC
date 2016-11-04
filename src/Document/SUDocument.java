package Document;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFileChooser;
/**
 * ��ʦѡ���ļ�����
 * @author Administrator
 *
 */
public class SUDocument extends Thread{
//�ͻ���
	private String ip = "127.0.0.1";// ���óɷ�����IP
	private int port = 8822;//���ö˿ں�
	public void run(){
		//�ϴ��ļ����������ļ����䵽��������
		try {
			ServerSocket server= new ServerSocket(port);
			//        Socket socket = new Socket(ip,port); 
//			while (true) {

				//            	String filePath="C:\\Users\\Administrator\\Desktop\\a\\����֪ʶ\\1.docx";
				// �����ļ�ѡ����
				JFileChooser jf = new JFileChooser();
				//��ʱ��ʾ�ļ���Ŀ¼
				jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				//���������ļ���ѡ���            	
				jf.showOpenDialog(null);
				//����ѡ�е��ļ�            	
				String filePath = jf.getSelectedFile().getPath();

				File fi = new File(filePath);
				System.out.println("�ļ�����:" + (int) fi.length());
				/* DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
                dis.readByte();
				 */
				Socket socket = server.accept(); 

				DataInputStream fis = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
				DataOutputStream ps = new DataOutputStream(socket.getOutputStream());
				//���ļ��������ȴ����ͻ��ˡ�����Ҫ������������ƽ̨�������������Ĵ�������Ҫ�ӹ���������Բμ�Think In Java 4th�����ֳɵĴ��롣
				ps.writeUTF(fi.getName());
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
	public static void main(String arg[]) {
		new SUDocument().start();;
	}
}  

