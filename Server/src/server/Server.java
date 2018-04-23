/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simone.bolzonella
 */
public class Server {
	static DatagramSocket socket;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args){
		try{
		socket=new DatagramSocket(1025,InetAddress.getLocalHost());
		new Thread(new ServerPacketListener(socket)).start();
		}catch(SocketException e){
			e.printStackTrace();
		} catch (UnknownHostException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
