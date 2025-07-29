package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controller.HomeController;

public class Home {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 318, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 21, 287, 74);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_title = new JLabel("<html>Welcome To Chat Room!.<br>Please To Choose Your Name.</html>");
		lbl_title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_title.setBounds(10, 7, 274, 62);
		panel.add(lbl_title);
		
		ActionListener ac = new HomeController(this);
		
		JButton btn_NVT = new JButton("Nguyễn Vũ Triết");
		btn_NVT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btn_NVT.setBounds(10, 105, 287, 42);
		btn_NVT.addActionListener(ac);
		frame.getContentPane().add(btn_NVT);
		
		JButton btn_NVM = new JButton("Nguyễn Vũ Minh");
		btn_NVM.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btn_NVM.setBounds(10, 154, 287, 42);
		btn_NVM.addActionListener(ac);
		frame.getContentPane().add(btn_NVM);
		
		JButton btn_BTTH = new JButton("Bùi Thị Thu Thảo");
		btn_BTTH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btn_BTTH.setBounds(10, 206, 287, 42);
		btn_BTTH.addActionListener(ac);
		frame.getContentPane().add(btn_BTTH);
		
		JButton btn_PTHB = new JButton("Phan Tống Hoàng Bang");
		btn_PTHB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btn_PTHB.setBounds(10, 258, 287, 42);
		btn_PTHB.addActionListener(ac);
		frame.getContentPane().add(btn_PTHB);
	}
}
