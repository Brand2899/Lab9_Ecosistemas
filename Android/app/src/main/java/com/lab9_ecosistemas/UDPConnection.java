package com.lab9_ecosistemas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPConnection extends Thread{

    private DatagramSocket socket;

    public void run(){

        try {
            // 1. Escuchar
            socket = new DatagramSocket(5052);

            // 2. Esperar Mensajes
            while (true){
                byte buffer[] = new byte[100];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                String message = new String(packet.getData()).trim();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        new Thread(
                ()-> {
                    // necesita 4 parametros en constructor
                    try {
                        InetAddress	ip = InetAddress.getByName("192.168.1.68");
                        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, ip, 5045);
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
