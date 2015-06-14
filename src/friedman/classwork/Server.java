package friedman.classwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//server listens
	//socket = endpoints of communications 
	public static void main(String [] args){
		try {
			ServerSocket ss = new ServerSocket(3763);//listens for the Server's side of the socket

			Socket s = ss.accept();//accept method returns a socket, this is a blocking call and the prog x adv til the socket is returned
			InputStream in;
			in = s.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));//gives u strings as opposed to bytes			

			String line;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}

	} catch (IOException e) {
		e.printStackTrace();
	}
}
}