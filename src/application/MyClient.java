package application;

import java.net.*;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author Arafin
 *
 */
public class MyClient{
	
	int i;
	String ip;
	Socket client;
	public static String msg, ipAdd;
	
	MyController controller;
	
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
		
		while(true) {
	        Robot robot;
			try {
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
			} catch (AWTException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
