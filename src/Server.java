 // Server.java
 
 // import java.net.ServerSocket;
 // import java.net.Socket;
 import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
 
 public class Server {
    public static void main(String[] args) {
        
    	try {
			// Server aufbauen
			ServerSocket server = new ServerSocket(11111);
			Socket s;
			while(true) {
			// Auf verbindung warten
			s = server.accept();
			// kommunikation an einen nebenläufigen Thread abgeben
			ServerThread t = new ServerThread(s);
			t.start();
			// und wieder auf neue Verbindungen warten
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
   
 }