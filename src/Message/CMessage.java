package Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;

/**
 * ѧ���˷�����Ϣ
 */

//���������Ϣ����ʼ����
public class CMessage {
	private Socket socket;
	private PrintWriter out;
	private int count=1;
	
	public CMessage(){
		//����this(null)ѧ������һ����Ϣ���Զ��˳�
//		this(null);
		this.connect();
	}
	
	//�˷��������ж�ѧ��
	public CMessage(String clientName){
		this.connect(clientName);
	}
	
	private void connect() {
		try{
			socket=new Socket("127.0.0.1",10000);
			System.out.println("��������Ϣ");
			out=new PrintWriter(socket.getOutputStream());
			//�ӿ���̨������Ϣ
			BufferedReader line=new BufferedReader(new InputStreamReader(System.in));
			//������Ϣ��������
			
			out.println(line.readLine());
			out.close();
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	private void connect(String name) {
		try{
			socket=new Socket("127.0.0.1",10000);
			System.out.println("��������Ϣ");
			out=new PrintWriter(socket.getOutputStream());
			//�ӿ���̨������Ϣ
			BufferedReader line=new BufferedReader(new InputStreamReader(System.in));
			//������Ϣ��������
			
			out.println(name+line.readLine());
			out.close();
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new CMessage();
	}
}

///**
// * ѧ���˷�����Ϣ
// * @author Administrator
// *
// */
//
//public class CMessage extends Thread{
//	private InputStream is=null;
//	private OutputStream os=null;
//	private ServerSocket server=null;
//	
//	public void run(){
//		try {
//			server =new ServerSocket(8888);
//			System.out.println("�ȴ�����");
//			Socket socket=server.accept();
////			System.out.println(socket.getRemoteSocketAddress()+"����");
//			is=socket.getInputStream();
//			os=socket.getOutputStream();
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		OutputStreamWriter osw=null;
//		InputStreamReader isr=null;
//		BufferedReader br=null;
//		
//		isr=new InputStreamReader(is);
//		br=new BufferedReader(isr);
//		String s;
//		try {
//			while((s=br.readLine()) != null){
//				System.out.print(s);
//			}
//			System.out.println();
////			System.out.println("111");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//		CMessage c=new CMessage();
//		c.start();
//	}
//}
