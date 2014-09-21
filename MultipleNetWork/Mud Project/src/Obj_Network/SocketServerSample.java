package Obj_Network;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.ObjectInputStream;

public class SocketServerSample {

	public static void main(String[] args) {
		SocketServerSample sample = new SocketServerSample();
		sample.startServer();
	}
	
	public void startServer() {
		ServerSocket server = null;
		Socket client = null;
		ObjectInputStream ois = null;
		
		try {
			server = new ServerSocket(9999);
			while(true) {
				System.out.println("Server : Waiting for request.");
				client = server.accept();
				System.out.println("Server : Accepted");
				InputStream stream = client.getInputStream();
//				BufferedReader in = new BufferedReader(
//						new InputStreamReader(stream));
				/*
				String data = null;
				StringBuilder receivedData = new StringBuilder();
				while ((data = in.readLine()) != null) {
					receivedData.append(data);
				}
				System.out.println("Received data : " + receivedData);
				*/
				
				ois = new ObjectInputStream(stream);
				Share share = (Share)ois.readObject();
				System.out.println("number = " + share.a + "string = " + share.str);				
				
//				in.close();
				stream.close();
				client.close();
				/*
				if (receivedData.toString().equals("EXIT")) {
					System.out.println("Stop SocketServer");
					break;
				}
				*/
				
				if (share.str.toString().equals("EXIT")) {
					System.out.println("Stop SocketServer");
					break;
				}
				
				System.out.println("-----------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(ois != null) {
				try {
					ois.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			try {
				server.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
