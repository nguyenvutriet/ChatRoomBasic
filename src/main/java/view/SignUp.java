package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

import controller.SignUpController;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SignUp {

	public JFrame frame;
	public JTextField JT_DateOfBirth;
	public JTextField tF_Phone;
	public JTextField tF_Address;
	public JTextField tF_user;
	public JTextField tF_Password;
	public String name;
	private JLabel lbl_DateofSignIn;
	public String time;
	public JLabel lbl_Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp("");
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
	public SignUp(String name) {
		initialize();
		this.name = name;
		LocalDateTime cunrrentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		time = cunrrentTime.format(formatter);
		lbl_DateofSignIn.setText("Date of sign up: " + time);
		lbl_Name.setText("Name: " + name);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 10));
		frame.setBounds(100, 100, 450, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_SignUP = new JLabel("SIGN UP YOUR ACCOUNT!");
		lbl_SignUP.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_SignUP.setBounds(10, 10, 416, 24);
		frame.getContentPane().add(lbl_SignUP);
		
		lbl_Name = new JLabel("Name:");
		lbl_Name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_Name.setBounds(10, 79, 416, 24);
		frame.getContentPane().add(lbl_Name);
		
		JSeparator separator = new JSeparator();
		separator.setToolTipText("");
		separator.setBounds(10, 32, 416, 2);
		frame.getContentPane().add(separator);
		
		JLabel lbl_SignUP_1 = new JLabel("Persional Information");
		lbl_SignUP_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lbl_SignUP_1.setBounds(10, 44, 416, 24);
		frame.getContentPane().add(lbl_SignUP_1);
		
		JLabel lbl_dateOfBirth = new JLabel("Date of birth:");
		lbl_dateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_dateOfBirth.setBounds(10, 113, 111, 24);
		frame.getContentPane().add(lbl_dateOfBirth);
		
		JT_DateOfBirth = new JTextField();
		JT_DateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JT_DateOfBirth.setBounds(124, 113, 176, 24);
		frame.getContentPane().add(JT_DateOfBirth);
		JT_DateOfBirth.setColumns(10);
		
		JLabel lbl_SDT = new JLabel("Phone number:");
		lbl_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_SDT.setBounds(10, 147, 123, 24);
		frame.getContentPane().add(lbl_SDT);
		
		JLabel lbl_address = new JLabel("Address:");
		lbl_address.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_address.setBounds(10, 181, 111, 24);
		frame.getContentPane().add(lbl_address);
		
		tF_Phone = new JTextField();
		tF_Phone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_Phone.setColumns(10);
		tF_Phone.setBounds(134, 147, 166, 24);
		frame.getContentPane().add(tF_Phone);
		
		tF_Address = new JTextField();
		tF_Address.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_Address.setColumns(10);
		tF_Address.setBounds(91, 181, 335, 24);
		frame.getContentPane().add(tF_Address);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setToolTipText("");
		separator_1.setBounds(10, 215, 416, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lbl_Account = new JLabel("Your Account\r\n");
		lbl_Account.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lbl_Account.setBounds(10, 227, 416, 24);
		frame.getContentPane().add(lbl_Account);
		
		lbl_DateofSignIn = new JLabel("Date of sign up:");
		lbl_DateofSignIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_DateofSignIn.setBounds(10, 261, 416, 24);
		frame.getContentPane().add(lbl_DateofSignIn);
		
		JLabel lbl_DateofSignIn_1 = new JLabel("Username:");
		lbl_DateofSignIn_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_DateofSignIn_1.setBounds(10, 295, 93, 24);
		frame.getContentPane().add(lbl_DateofSignIn_1);
		
		tF_user = new JTextField();
		tF_user.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_user.setColumns(10);
		tF_user.setBounds(101, 295, 199, 24);
		frame.getContentPane().add(tF_user);
		
		JLabel lbl_DateofSignIn_1_1 = new JLabel("Username:");
		lbl_DateofSignIn_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_DateofSignIn_1_1.setBounds(10, 329, 93, 24);
		frame.getContentPane().add(lbl_DateofSignIn_1_1);
		
		tF_Password = new JTextField();
		tF_Password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_Password.setColumns(10);
		tF_Password.setBounds(101, 329, 199, 24);
		frame.getContentPane().add(tF_Password);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setToolTipText("");
		separator_1_1.setBounds(10, 363, 416, 2);
		frame.getContentPane().add(separator_1_1);
		
		ActionListener ac = new SignUpController(this);
		
		JButton btn_SignUp = new JButton("Sign Up");
		btn_SignUp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn_SignUp.setBounds(320, 375, 106, 30);
		btn_SignUp.addActionListener(ac);
		frame.getContentPane().add(btn_SignUp);
		
		JButton btn_Clean = new JButton("Clean");
		btn_Clean.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn_Clean.setBounds(10, 375, 106, 30);
		btn_Clean.addActionListener(ac);
		frame.getContentPane().add(btn_Clean);
	}
	public void Inform() {
		JOptionPane.showMessageDialog(frame, "Sign up is successfull!");
	}
	public void Faild() {
		JOptionPane.showMessageDialog(frame, "Sign is failed!");
	}
	public void reset() {
		JT_DateOfBirth.setText("");
		tF_Address.setText("");
		tF_Password.setText("");
		tF_Phone.setText("");
		tF_user.setText("");
	}
}
