package test;

import javax.swing.UIManager;

import view.Home;

public class TestMain {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Home home = new Home();
			home.frame.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
