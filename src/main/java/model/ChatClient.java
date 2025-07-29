package model;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.file.attribute.AclEntry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controller.ChatController;
import util.HibernateUtil_;

public class ChatClient {
	private static final String url = "localhost";
	private static final int port = 9875;
	private ChatController chat;
	private String name;

	public ChatClient(ChatController chat, String name) {
		this.chat = chat;
		this.name = name;

	}

	public void startClient() {
		try {
			Socket socket = new Socket(url, port);
			System.out.println("Server connected!");
			LocalDateTime current = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String time = current.format(formatter);
			chat.setMessage(" joined...");
			// chat.setTA();
			chat.setFlag(true);

			// liên tục đọc dữ liệu từ Server
			ListenerClient listenerClient = new ListenerClient(socket, chat);
			new Thread(listenerClient).start();

//			//liên tục đọc dữ liệu từ chat
//			OutputStream output = socket.getOutputStream();
//			while(true) {
//				if(chat.flag) {
//					System.out.println("Flag: " + chat.flag);
//					LocalDateTime curren = LocalDateTime.now();
//					DateTimeFormatter formatte = DateTimeFormatter.ofPattern("HH:mm:ss");
//					String  time1 = curren.format(formatte);
//					String msg = "[" + time1 + "] " + name + ": " + chat.getMessage();
//					output.write(msg.getBytes());
//					output.flush();
//					System.out.println("Send: " + msg);
//					chat.setFlag(false);
//				}
//			}
			OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			while (true) {
				if (chat.flag) {
					LocalDateTime current1 = LocalDateTime.now();
					DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
					String time1 = current1.format(formatter1);

					String msg = "[" + time1 + "] " + name + ": " + chat.getMessage();
					bufferedWriter.write(msg);
					bufferedWriter.flush(); 
					chat.setFlag(false);
				}
				Thread.sleep(10); 
			}

		} catch (Exception e) {
			// TODO: handle exception
			chat.closChat();
			HibernateUtil_.writeFileLong(e.getMessage());
			e.printStackTrace();
		}
	}
}
