package application;

import java.net.Socket;

/**
 * @author Arafin
 *
 */
public class Handler {
	
	public static String clientMsg, serverMsg;
	public static Socket socketClient, socketServer;
	
	
	//SOCKETS
	public static Socket getSocketClient() {
		return socketClient;
	}

	public static Socket getSocketServer() {
		return socketServer;
	}

	public static void setSocketClient(Socket socketClient) {
		Handler.socketClient = socketClient;
	}

	public static void setSocketServer(Socket socketServer) {
		Handler.socketServer = socketServer;
	}

	//MESSAGES
	public static String getClientMsg() {
		return clientMsg;
	}

	public static String getServerMsg() {
		return serverMsg;
	}

	public static void setClientMsg(String clientMsg) {
		Handler.clientMsg = clientMsg;
	}

	public static void setServerMsg(String serverMsg) {
		Handler.serverMsg = serverMsg;
	}	
}
