package Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket;
	private BufferedReader br;
	public ServerThread(Socket s){
		super();
		this.socket=socket;
		try{
			this.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try{
			//�õ�ѧ���˵�������
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//����̨������Ϣ
			System.out.println(br.readLine());
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
