package model;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import util.HibernateUtil_;



public class ClientHandler implements Runnable{
	private Socket mySocket;
	private ChatServer chatServer;
	private InputStream input;
	private OutputStream ouput;
	private int id;
	
	public ClientHandler(Socket mySocket, ChatServer chatServer, int id) {
		this.mySocket = mySocket;
		this.chatServer = chatServer;
		this.id = id;
		try {
			this.input = this.mySocket.getInputStream();
			this.ouput = this.mySocket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			byte[] buffer = new byte[1024];
			int byteRead;
			while((byteRead = input.read(buffer)) != -1) {
				String message = new String(buffer, 0, byteRead, "UTF-8");
				chatServer.broadcastMessage(message, id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
			e.printStackTrace();
		} finally {
			// đóng socket khi client rời
			try {
				chatServer.removeClient(id);
				mySocket.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public void sendMessage(String message) {
		try {
			if (mySocket != null && !mySocket.isClosed()) {
				ouput.write(message.getBytes("UTF-8"));
				ouput.flush();
			}
		}catch (SocketException e) {
			System.out.println("Socket bị đóng: " + e.getMessage());
			e.printStackTrace();
			HibernateUtil_.writeFileLong(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			HibernateUtil_.writeFileLong(e.getMessage());
		}
	}
}
