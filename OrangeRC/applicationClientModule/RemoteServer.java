import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class RemoteServer {  
    
    public static final int USERNUM = 60;
	private static String ip;
    private static Socket st;
    private static String[] ips = new String[USERNUM];
    private static int order = 0;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
    	
    	@SuppressWarnings("unused")
		final int USERNUM = 56;
    	
    	//new Login();
    	new GUI();
        ServerSocket server = null;  
        try {  
            server = new ServerSocket(1123);
			while(true){
				try {
					st = server.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				ip = st.getInetAddress().getHostAddress();
				new Receive(st, ip,getorder(ip)).start();
			}
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }
	public static int getorder(String oip){
    	for(int i=0;i<order;i++){
    		if(ips[i].equals(oip)){
    			return i;
    		}
    	}
    	ips[order]=oip;
    	order++;
    	return order-1;
    }
}  
  
  
