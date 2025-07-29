package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import model.ChatClient;
import model.ChatServer;
import util.HibernateUtil_;
import view.Chat;

public class ChatController implements ActionListener{
	private Chat view;
	public String message;
	private ChatClient client;
	public String name;
	public boolean flag;
	
	public ChatController(Chat view) {
		this.view = view;
		this.message = "";
		this.name = view.name;
		this.flag = false;
		checkServer();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil_.writeFileLong(e.getMessage());
		}
		startChat();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttton = e.getActionCommand();
		if(buttton.equals("Send")) {
			if(!view.tF_entry.getText().equals("")) {
				setMessage(view.tF_entry.getText());
				setFlag(true);
				view.tF_entry.setText("");
			}else {
				view.Inform();
			}
		}	
	}
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void startChat() {
		new Thread(() ->{
			client = new ChatClient(this, name);
			client.startClient();
		}).start();
	}
	public void setTA() {
		view.set_tA_Screen(message);
	}
	private void checkServer() {
		if(!isServerRunning("localhost", 9875)) {
			new Thread(() -> {
				ChatServer server = new ChatServer();
				server.startServer();
			}).start();
		}
	}
	private boolean isServerRunning(String host, int port) {
		try(Socket s = new Socket(host, port)) {
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
			return false;
		}
	}
	public void closChat() {
		view.frame.dispose();
	}
	
}
