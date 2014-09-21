package Obj_Network;

//import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

import java.io.ObjectOutputStream;

public class SocketClientSample {

	public static void main(String[] args) {
		SocketClientSample sample = new SocketClientSample();
		sample.sendSocketSample();
	}

	public void sendSocketSample() {
		for (int loop = 0; loop < 3; loop++) {
			sendSocketData("I liked java at " + new Date());
		}
		sendSocketData("EXIT");
	}
	
	public void sendSocketData(String data) {
		Socket socket = null;
		ObjectOutputStream oos = null;
		
		try {
			System.out.println("Client : Connecting");
			socket = new Socket("127.0.0.1", 9999);
			System.out.println("Client : Connect status = " + socket.isConnected());
			Thread.sleep(1000);
			OutputStream stream = socket.getOutputStream();
			
//			BufferedOutputStream out = new BufferedOutputStream(stream);
			
			Share share = new Share();
			share.a = 5;
			share.str = data;
			
			oos = new ObjectOutputStream(stream);
			
			oos.writeObject(share);
			
//			byte[] bytes = data.getBytes();				
//			out.write(bytes);
			System.out.println("Client : Sent Data");
//			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(oos != null) {
					try {
						oos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
