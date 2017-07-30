package application;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Arafin
 *
 */
public class MyClient{
	
	int i;	
	public static String msg, ipAdd;
	String ip;
	
	MyController controller;
    
	Robot robot;
	Socket client;

	public MyClient(String ip) {
		try {
			client = new Socket(ip, 3000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendDataToServer() throws IOException {
		controller = new MyController();
		i = 0;
		
		try {
			while(true) {
				robot = new Robot();
		        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        ImageIO.write(screenShot, "jpg", baos );
		        baos.flush();
		        byte[] buffer = baos.toByteArray();
		        
				ObjectOutputStream objOp = new ObjectOutputStream(client.getOutputStream());
//					Handler.setClientMsg(InetAddress.getLocalHost().getHostName() + "\nMessages from Client");
				objOp.writeObject(buffer);
				
				i++;
				System.out.println(i + " image reached!");
				
				Thread.sleep(5000);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
