
import java.net.*;

public class ServiceServer {
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9002);
			while (true) {
				Socket client =serverSocket.accept();
				Thread thread = new ServerThread(client);
				thread.start();
			}
		} catch (Exception e) {
			
		}
		
	}

}
