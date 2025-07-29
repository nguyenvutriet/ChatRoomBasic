package model;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import util.HibernateUtil_;

public class ChatServer {
	private static final int port = 9875;
	private List<ClientHandler> clients = new ArrayList<ClientHandler>();
	private List<String> dsJoined = new ArrayList<String>();
	private int ids = 0;
	public void startServer() {
		try {
			ServerSocket socket = new ServerSocket(port, 50, InetAddress.getByName("0.0.0.0"));
			System.out.println("Server is running...");
			
			while(true) {
				Socket client = socket.accept();
				System.out.println("Client: " + client.getInetAddress());
				ClientHandler clienthandler = new ClientHandler(client, this, ids);
				System.out.println();
				clients.add(clienthandler);
				ids++;
				new Thread(clienthandler).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
		}
	}
	public void broadcastMessage(String message, int id) {
		if(message.substring(message.length() - 9).equals("joined...")) {
			if(checkList(message)) {
				//gửi thông báo từ chối kết nối
				clients.get(id).sendMessage("rejected");
				clients.remove(id);
				ids--;
				return;
				
			}else {
				dsJoined.add(message.substring(11));
			}
		}
		for(ClientHandler client : clients) {
			if(client != null) {
				client.sendMessage(message);
			}
		}
	}
	private boolean checkList(String msg) {
		if(dsJoined.size() == 0) return false;
		for(int i = 0; i < dsJoined.size(); i++) {
			if(msg.substring(11).equals(dsJoined.get(i))) {
				return true;
			}
		}
		return false;
	}
	public void removeClient(int id) {
	    if (id < clients.size() && clients.get(id) != null) {
	        try {
	            System.out.println("Removing client with id: " + id);
	            clients.set(id, null); 
	        } catch (Exception e) {
	            HibernateUtil_.writeFileLong("Lỗi khi xóa client: " + e.getMessage());
	        }
	    }
	}
}
