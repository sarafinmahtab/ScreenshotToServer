package application;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.io.*;

/**
 * @author Arafin
 *
 */
public class ClientHandler extends Thread {
	
	private Socket socket;

	static String msg;

	private ObjectInputStream objIp;

	private FileOutputStream fos;
	
    SimpleDateFormat formatter;

    Calendar now;
	
	public ClientHandler() {
		socket = Handler.getSocketServer();
		
		formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				now = Calendar.getInstance();
				
				objIp = new ObjectInputStream(socket.getInputStream());
				
				byte[] buffer = (byte[]) objIp.readObject();
					
				fos = new FileOutputStream("g:\\ScreenShot\\"+formatter.format(now.getTime())+".jpg");
					
				fos.write(buffer);
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
            return;
		} catch (IOException e) {
			return;
		} catch(Exception e) {
			e.printStackTrace();
            return;
		}
	}
}
