package Client;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;
/**
 * 客户端接收服务器端信息
 * 控制鼠标，键盘
 * 
 * @author MIKORU
 * @date 2016.10.26
 */
class EventThread extends Thread{ 
    private ObjectInput objectIn; 
    private Robot robot;
    private Socket st;
    public EventThread(Socket st){ 
        this.st = st; 
    } 
    public void run() { 
        try { 
            robot = new Robot(); 
            while(true){
            	objectIn = new ObjectInputStream(st.getInputStream());
                Object event = objectIn.readObject(); 
                InputEvent inEvent = (InputEvent)event; 
                actionEvent(inEvent); 
            }
        } catch (Exception e) { 
            e.printStackTrace();
            
        } 
    }
    public void actionEvent(InputEvent event){ 
        if(event instanceof KeyEvent){ 
            KeyEvent e = (KeyEvent)event; 
            int type = e.getID(); //获取事件类型 
            if(type==Event.KEY_PRESS){ 
                robot.keyPress(e.getKeyCode()); 
            }else if(type==Event.KEY_RELEASE){ 
                robot.keyRelease(e.getKeyCode()); 
            } 
        }else{
            MouseEvent e = (MouseEvent)event; 
            int type = e.getID(); 
            if(type == Event.MOUSE_DOWN){ 
                robot.mousePress(getMouseButton(e.getButton())); 
            }else if(type == Event.MOUSE_UP){ 
                robot.mouseRelease(getMouseButton(e.getButton()));  
            }else if(type == Event.MOUSE_MOVE){ 
                robot.mouseMove(e.getX(), e.getY()); 
            }else if(type == Event.MOUSE_DRAG){ 
                robot.mouseMove(e.getX(), e.getY()); 
            } 
        } 
    } 
    private int getMouseButton(int button){ 
        if(button == MouseEvent.BUTTON1){ 
            return InputEvent.BUTTON1_MASK; 
        }else if(button == MouseEvent.BUTTON2){ 
            return InputEvent.BUTTON2_MASK; 
        }if(button == MouseEvent.BUTTON3){ 
            return InputEvent.BUTTON3_MASK; 
        }else{ 
            return -1; 
        } 
    } 
}