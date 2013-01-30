import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread {
private Socket s;
public ServerThread(Socket s) {
this.s = s;
}
 
public void run () {
	
try {
	BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	String data = in.readLine();
	System.out.println("raw "+data);
	
	String string = data;
	String[] parts = string.split("#");
	String part1 = parts[0];
	String part2 = parts[1];
	String part3 = parts[2]; 
	System.out.println("p1 "+part1);
	System.out.println("p2 "+part2);
	System.out.println("p3 "+part3);
	
	// schreiben
	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	out.write(data.toUpperCase());
	out.newLine();
	out.flush();
	
	// aufräumen
	out.close();
	in.close();

	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}
}