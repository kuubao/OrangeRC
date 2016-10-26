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
 * 教师选择文件发送
 * @author Administrator
 *
 */
public class CDocument extends Thread{
//客户端
	private String ip = "127.0.0.1";// 设置成服务器IP
	private int port = 8822;//设置端口号
	public void run(){
		//上传文件，将本地文件传输到服务器端
		try {
			ServerSocket server= new ServerSocket(port);
			//        Socket socket = new Socket(ip,port); 
			while (true) {

				//            	String filePath="C:\\Users\\Administrator\\Desktop\\a\\电脑知识\\1.docx";
				// 创建文件选择器
				JFileChooser jf = new JFileChooser();
				//打开时显示文件和目录
				jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				//弹出“打开文件”选择框            	
				jf.showOpenDialog(null);
				//返回选中的文件            	
				String filePath = jf.getSelectedFile().getPath();

				File fi = new File(filePath);
				System.out.println("文件长度:" + (int) fi.length());
				/* DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
                dis.readByte();
				 */
				Socket socket = server.accept(); 

				DataInputStream fis = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
				DataOutputStream ps = new DataOutputStream(socket.getOutputStream());
				//将文件名及长度传给客户端。这里要真正适用所有平台，例如中文名的处理，还需要加工，具体可以参见Think In Java 4th里有现成的代码。
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
				// 注意关闭socket链接哦，不然客户端会等待server的数据过来，
				// 直到socket超时，导致数据不完整。                
				fis.close();
				socket.close();                
				System.out.println("文件传输完成");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
 /**
  * 教师接收文件   
  */
public void DownFile(){
//从服务器端下载文件
try { 
    Socket socket = new Socket(ip,port);
           while(true){  
               DataInputStream is = new  DataInputStream(socket.getInputStream());   
               OutputStream os = socket.getOutputStream();                  
               //1、得到文件名       
               String filename="E:\\";
               filename += is.readUTF(); 
             
               System.out.println("新生成的文件名为:"+filename);  
               FileOutputStream fos=new FileOutputStream(filename);
				//通过字节数组来缓冲数据（字节缓冲流）
               BufferedOutputStream bos=new BufferedOutputStream(fos);
               DataOutputStream dos = new DataOutputStream(bos);
               byte[] b = new byte[1024]; 
               int length = 0;  
               while((length=is.read(b))!=-1){  
                   //2、把socket输入流写到文件输出流中去  
                   fos.write(b, 0, length);  
               }  
               dos.flush();  
               dos.close();               
               is.close();  
               socket.close();  
           }  
             
       } catch (IOException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
       }   
}  
//public static void main(String arg[]) {
////String filepath="D:\\test.txt";
//       new CDocument().UpFile();;
//   }
}