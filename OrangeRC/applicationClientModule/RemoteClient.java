import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;



public class RemoteClient {  
	
	public static void main(String[] args) throws SocketException {
        Socket socket = null;  
        try {  
            socket = new Socket("127.0.0.1", 1123);
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {
            e.printStackTrace();  
        }
        new SendThread(socket).start();
    }
}