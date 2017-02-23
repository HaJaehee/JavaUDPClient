import java.io.IOException;
import java.net.UnknownHostException;
import java.net.*;
import java.io.*;

public class UDPClient
{
	public static void main(String[] args){
		String hostname = "localhost";
		int port = 10000;

		try{
			String strInput = "hi hi hello";
			DatagramPacket outPacket;

			InetAddress server = InetAddress.getByName(hostname);

			DatagramSocket dSock = new DatagramSocket();

			byte[] data = strInput.getBytes();

			outPacket = new DatagramPacket(data, data.length, server, port);

			System.out.println("��Ŷ�� ��� �ּ�:"+outPacket.getAddress().toString());
			System.out.println("��Ŷ�� ��� ��Ʈ:"+outPacket.getPort());
			System.out.println("��Ŷ�� ������ ũ��:"+outPacket.getLength());
			
			dSock.send(outPacket);

		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(SocketException se){
			se.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

