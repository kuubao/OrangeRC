package Message;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 教师端接收信息
 */


//教师需要开机自动运行端口
//等待学生打开客户端
//教师端接收数据

public class SMessage extends ServerSocket{
	private static int port=10000;
	public SMessage() throws IOException {
		super(port);
		try{
			System.out.println("启动服务器");
			while(true){
				Socket socket=this.accept();
				new ServerThread(socket);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			this.close();
		}
	}
	public static void main(String[] args) throws IOException {
		new SMessage();
	}

}
//public class SMessage extends Thread{
//	private Socket socket=null;
//	private OutputStream os=null;
//	private OutputStreamWriter osw=null;
//	private BufferedWriter bw=null;
//	public void run(){
//		try {
//			socket=new Socket("127.0.0.1",8888);
//			os=socket.getOutputStream();
//			osw=new OutputStreamWriter(os);
//			bw=new BufferedWriter(osw);
//			//readLine()必须有结束标志\r\n
//			bw.write("nihao\n\r");
//			bw.flush();
//			bw.close();
////			System.out.println("222");
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public static void main(String[] args) {
//		SMessage d=new SMessage();
//		d.start();
//	}
//}
