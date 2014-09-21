
//import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread{
	
	static List<Player> list = 
			Collections.synchronizedList(new ArrayList<Player>());
	
	Socket client;
	InputStream inStream;
	ObjectInputStream ois;		
	OutputStream outStream;
	ObjectOutputStream oos;
	
	ServerThread(Socket client) {
		this.client = client;
		
		try {
			inStream = client.getInputStream();
			ois = new ObjectInputStream(inStream);			
			outStream = client.getOutputStream();
			oos = new ObjectOutputStream(outStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public void run() {
		
		try {
			Object obj = ois.readObject();
			
			if (obj instanceof Player) {
				Player player = (Player)obj;
				System.out.println("#" + player.name);
			}
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}	
}
