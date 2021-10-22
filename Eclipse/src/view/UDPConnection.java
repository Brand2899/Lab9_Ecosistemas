 package view;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPConnection extends Thread{
	
	private DatagramSocket socket;
	private String senderIP;
	private int senderPort;
	
	public void run() {
		try {
			//1. Fase de escuchar
			socket = new DatagramSocket(5045);
			
			//2. Fase de esperar mensajes: Datagrams
			while(true) {
				
				// necesita 2 parametros en constructor
				byte buffer[] = new byte[100];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				
				System.out.println("Esperando Datagrama");
				socket.receive(packet);
				
				String[] messageAddress = packet.getSocketAddress().toString().split(":");
				senderIP = messageAddress[0].replace("/", "");
				senderPort = Integer.parseInt(messageAddress[1]);
				
				String message = new String(packet.getData()).trim();
				System.out.println("Datagrama recibido " + message + " ip: " + senderIP + " puerto: " + senderPort);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		new Thread(
				()-> {
					// necesita 4 parametros en constructor
					try {
						InetAddress	ip = InetAddress.getByName("192.168.1.68");
						DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, ip, 5052);
						socket.send(packet);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();	
	}
}
