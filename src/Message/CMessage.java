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
 * 学生端发送信息
 */

//点击发送信息，开始连接
public class CMessage {
	private Socket socket;
	private PrintWriter out;
	private int count=1;
	
	public CMessage(){
		//屏蔽this(null)学生输入一个信息后自动退出
//		this(null);
		this.connect();
	}
	
	//此方法用于判断学生
	public CMessage(String clientName){
		this.connect(clientName);
	}
	
	private void connect() {
		try{
			socket=new Socket("127.0.0.1",10000);
			System.out.println("请输入信息");
			out=new PrintWriter(socket.getOutputStream());
			//从控制台输入信息
			BufferedReader line=new BufferedReader(new InputStreamReader(System.in));
			//输入信息到服务器
			
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
			System.out.println("请输入信息");
			out=new PrintWriter(socket.getOutputStream());
			//从控制台输入信息
			BufferedReader line=new BufferedReader(new InputStreamReader(System.in));
			//输入信息到服务器
			
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
// * 学生端发送消息
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
//			System.out.println("等待连接");
//			Socket socket=server.accept();
////			System.out.println(socket.getRemoteSocketAddress()+"连接");
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
