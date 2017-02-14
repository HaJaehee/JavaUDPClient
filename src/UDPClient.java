import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class UDPClient {
  	
	public UDPClient () {
		
	}
	
	public static void main(String[] args) {
	  	int DHTServerSocket = 10000;
	  	Socket DHTSvrSocket;
		try {
			DHTSvrSocket = new Socket("localhost", DHTServerSocket);
		  	BufferedWriter outToSoc = new BufferedWriter(
					new OutputStreamWriter(DHTSvrSocket.getOutputStream(),Charset.forName("UTF-8")));
		  	
		  	ServerSocket Sock = new ServerSocket(0);
		  	int rplPort = Sock.getLocalPort();
		  	System.out.print("send msg to DHT server :");
		  	System.out.println("Reply port :"+rplPort);
		  	outToSoc.write(rplPort+"");
		  	outToSoc.flush();
		  	outToSoc.close();
		  	DHTSvrSocket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	

	}

}
