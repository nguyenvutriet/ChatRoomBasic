package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import dao.registerDAO;
import util.HibernateUtil;
import util.HibernateUtil_;
import view.Chat;
import view.Home;
import view.SignIn;
import view.SignUp;

public class SignInController implements ActionListener{
	private SignIn view;
	private registerDAO reDAO;
	private Chat viewChat;
	
	
	public SignInController(SignIn view) {
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("<<   RollBack")) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				Home home = new Home();
				home.frame.setVisible(true);
				
				view.frame.dispose();
				
			} catch (Exception e1) {
				// TODO: handle exception
				HibernateUtil_.writeFileLong(e1.getMessage());
			}
		}else if(button.equals("SignIn")) {
			reDAO = new registerDAO();
			if(view.textField.getText().equals("")) {
				view.Note();
			}
			else {
				if(!reDAO.examPassword(view.textField.getText(), view.name)) {
					view.textField.setText("");
					view.Error();
				}else {
					System.out.println("Welcome!");
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						viewChat = new Chat(view.name);
						viewChat.frame.setVisible(true);
						view.frame.dispose();
					} catch (Exception e2) {
						// TODO: handle exception
						HibernateUtil_.writeFileLong(e2.getMessage());
					}
				}
			}	
		}else if(button.equals("SignUp")) {
			reDAO = new registerDAO();
			if(reDAO.condition(view.name)) {
				view.Anouces();
			}else {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SignUp signUp = new SignUp(view.name);
					signUp.frame.setVisible(true);
					view.frame.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
					HibernateUtil_.writeFileLong(e2.getMessage());
				}
			}
		}
		
	}

}
