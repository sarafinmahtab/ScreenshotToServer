package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author Arafin
 *
 */
public class MyController implements Initializable {
	
	private Thread t;
	private MyClient myClient;
	
	Button send, receive;
	@FXML Label status, data;
	@FXML TextField messages;
	
	public static ArrayList<String> arrayList = new ArrayList<>();
	static boolean isClient = false, clientDataInput = false;
	
	@FXML
	public void openServer() {
		try {
			t = new MyServer();
			t.start();
			status.setText("Seaching clients....");
			
		} catch (Exception e) {
			status.setText("Failed to Search");
			e.printStackTrace();
		}
	}
	
	@FXML
	public void connectServer() {
		isClient = true;
		
		myClient = new MyClient("192.168.0.63");
//		myClient = new MyClient("10.100.5.128");
//		myClient = new MyClient("127.0.0.1");
		
		if(myClient.client.isConnected()) {
			status.setText("Connected to Server");
		} else {
			status.setText("Not Connected");
		}
	}
	
	@FXML
	public void takeScreenShot() {
		
		try {
			myClient.sendDataToServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		  new ClientHandler().start();
		
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Select Any File");
//        
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Document",
//                        "*.pdf", "*.docx"),
//                new FileChooser.ExtensionFilter("Image Files",
//                        "*.bmp", "*.png", "*.jpg", "*.gif"),
//                new FileChooser.ExtensionFilter("Video Files",
//                        "*.mkv", "*.mp4"),
//                new FileChooser.ExtensionFilter("Audio Files",
//                        "*.mp3", "*.m4p")
//                );
//        
//        File selectedFile = fileChooser.showOpenDialog(null);
//        
//        if (selectedFile != null) {
//
//        	dataStr = selectedFile.toURI().toURL().toString();
//        }
	}
	
	@FXML
	public void stop() {
		new ClientHandler().start();
	}
	
	@FXML
	public void close() {
		System.exit(0);
	}
	
	@Override
	public void initialize(URL address, ResourceBundle resource) {
		
//		InetAddress ipA;
//		
//		try {
//			ipA = InetAddress.getLocalHost();
//			ip = ipA.getHostAddress();
//			ipAdd.setText("Your IP Address is:\n" + ip);
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
	}
}
