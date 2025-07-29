package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ChatController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class Chat {

	public JFrame frame;
	public JTextField tF_entry;
	public String name;
	private JTextArea tA_Screen;
	private ActionListener controller;
	private JButton btn_Send;
	private JLabel lbl_Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat("");
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
	public Chat(String name) {
		this.name = name;
		initialize();
		controller = new ChatController(this);
		btn_Send.addActionListener(controller);
		lbl_Name.setText("Your Name: " + name);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 820, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tA_Screen = new JTextArea();
		tA_Screen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tA_Screen.setBounds(10, 51, 786, 335);
		tA_Screen.setEditable(false);
		frame.getContentPane().add(tA_Screen);
		
		tF_entry = new JTextField();
		tF_entry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tF_entry.setBounds(10, 396, 665, 34);
		frame.getContentPane().add(tF_entry);
		tF_entry.setColumns(10);
		
		btn_Send = new JButton("Send");
		btn_Send.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btn_Send.setBounds(685, 396, 111, 34);
		frame.getContentPane().add(btn_Send);
		
		lbl_Name = new JLabel("Your Name:");
		lbl_Name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_Name.setBounds(10, 10, 786, 39);
		frame.getContentPane().add(lbl_Name);
	}
	public void set_tA_Screen(String message) {
		tA_Screen.append(message + "\n");
	}
	public void Inform() {
		JOptionPane.showMessageDialog(frame, "Please enter the entry");
	}
}
