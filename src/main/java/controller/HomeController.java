package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import view.Home;
import view.SignIn;

public class HomeController implements ActionListener{
	private Home view;
	private SignIn signIn;
	
	public HomeController(Home view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = e.getActionCommand();
		if(button.equals("Nguyễn Vũ Triết")) {
			SetForm("Nguyễn Vũ Triết");
		}else if(button.equals("Nguyễn Vũ Minh")) {
			SetForm("Nguyễn Vũ Minh");
		}else if(button.equals("Bùi Thị Thu Thảo")) {
			SetForm("Bùi Thị Thu Thảo");
		}else if(button.equals("Phan Tống Hoàng Bang")) {
			SetForm("Phan Tống Hoàng Bang");
		}
	}
	public void SetForm(String name) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			signIn = new SignIn(name);
			signIn.frame.setVisible(true);
			view.frame.dispose();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
