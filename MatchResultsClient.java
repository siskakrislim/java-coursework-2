//Name: Siska Kristanti Lim
//Student number: 170281939
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MatchResultsClient {

	private int port = 6006;
	
	public void go(String host) {
		try {
			System.out.println("Contacting " + host + " on port " + port);
			
			Socket socket = new Socket("localhost", port);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ArrayList<DatedMatchResultV2> datedMatch = (ArrayList<DatedMatchResultV2>) ois.readObject();
			ois.close();
			socket.close();
			
			for(DatedMatchResultV2 element : datedMatch) {
				System.out.println(element);
			}
		} catch(UnknownHostException e) {
			System.out.println("Occurs an error called UnknownHostException");
		} catch(IOException e) {
			System.out.println("Occurs an error called IOException");
		} catch(ClassNotFoundException e) {
			System.out.println("Occurs an error called ClassNotFoundException");
		}
	}
	
	public static void main(final String[] args) {
		int numClients = 6;
		for(int i=0; i<numClients; i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					new MatchResultsClient().go(args[0]);;
				}
			});
			t.start();
		}
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("Occurs an error called InterruptedException");
		}
	}
}
