package model;

import java.io.InputStream;
import java.net.Socket;

import controller.ChatController;
import util.HibernateUtil_;

public class ListenerClient implements Runnable{
	private Socket socket;
	private InputStream input;
	private ChatController chat;
	
	public ListenerClient(Socket socket, ChatController chat) {
		this.chat = chat;
		this.socket = socket;
		try {
			this.input = socket.getInputStream();
		} catch (Exception e) {
			HibernateUtil_.writeFileLong(e.getMessage());
			e.printStackTrace();
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
				if(message.equals("rejected")) {
					socket.close();
					chat.closChat();
				}
				chat.setMessage(message);
				chat.setTA();
			}
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
