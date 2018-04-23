/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simone.bolzonella
 */
public class ServerPacketListener implements Runnable {
	DatagramSocket socket;
	public ServerPacketListener(DatagramSocket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		for(;;){
			DatagramPacket pacchetto=new DatagramPacket(new byte[1024],0,1024);
			try {
				socket.receive(pacchetto);
				System.out.println(new String(pacchetto.getData()));
			} catch (IOException ex) {
				Logger.getLogger(ServerPacketListener.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
}
