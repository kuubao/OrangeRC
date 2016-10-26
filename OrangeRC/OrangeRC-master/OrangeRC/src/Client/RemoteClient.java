package Client;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * Ô¶³Ì¼à¿Ø¿Í»§¶Ë
 * 
 * @author MIKORU
 *
 */
public class RemoteClient {  
	private static Socket socket;
	private static Socket socket2;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SocketException {
        //screen listener
        try {  
        	socket = new Socket("127.0.0.1", 1123);
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {
            e.printStackTrace();  
        }
        new SendThread(socket).start();
        
        //mouse listener
        try {
			socket2 = new Socket("127.0.0.1",1234);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        new EventThread(socket2).start();
    }
}