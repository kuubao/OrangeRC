package Document;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ��ʦ�����ļ����˿ں�8822��
 * ����ʱ��Ҫ׼���˿�
 * @author Administrator
 *
 */
public class SDocument extends ServerSocket{
	private static int port=8822;
	public SDocument() throws IOException{
		//�൱��ServerSocket server= new ServerSocket(port);
		super(port);
		try{
			System.out.println("�����ļ�����");
			while(true){
				Socket socket=this.accept();
				//����ѧ���������ļ�������
				//new Document(socket);
				//��ʦ�����ļ�
				new Document1(socket);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				this.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
	}
	public static void main(String[] args) {
		try {
			new SDocument();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
