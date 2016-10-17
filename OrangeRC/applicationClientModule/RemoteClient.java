import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;



public class RemoteClient {  
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SocketException {
        Socket socket = null;
        Socket st = null;
        ServerSocket server = null;  
        //ÆÁÄ»¼àÌý¶Ë¿Ú
        try {  
            socket = new Socket("127.0.0.1", 1123);
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {
            e.printStackTrace();  
        }
        new SendThread(socket).start();
        //Êó±ê¼àÌý¶Ë¿Ú
        try {
            server = new ServerSocket(1234);
			while(true){
				try {
					st = server.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				new EventThread(st).start();
			}
        } catch (IOException e) {  
            e.printStackTrace();
        }
    }
}