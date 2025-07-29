package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.SignInController;

public class SignIn {

	public JFrame frame;
	public JTextField textField;
	public JLabel lbl_Note;
	public JButton btn_QL;
	public String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn("");
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
	public SignIn(String name) {
		initialize();
		this.name = name;
		lbl_Note.setText("<html>Hi " + name + "!.<br>Please Enter Your Password.</html>");
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 396, 174);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(10, 42, 252, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lbl_MK = new JLabel("Password:");
		lbl_MK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_MK.setBounds(10, 10, 100, 27);
		frame.getContentPane().add(lbl_MK);
		
		lbl_Note = new JLabel();
		lbl_Note.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_Note.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lbl_Note.setBounds(10, 89, 252, 38);
		frame.getContentPane().add(lbl_Note);
		
		ActionListener ac = new SignInController(this);
		
		JButton btn_Enter = new JButton("SignIn");
		btn_Enter.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_Enter.setBounds(272, 42, 100, 37);
		btn_Enter.addActionListener(ac);
		frame.getContentPane().add(btn_Enter);
		
		JButton btn_SignUp = new JButton("SignUp");
		btn_SignUp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_SignUp.setBounds(273, 89, 99, 42);
		btn_SignUp.addActionListener(ac);
		frame.getContentPane().add(btn_SignUp);
		
		btn_QL = new JButton("<<   RollBack");
		btn_QL.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btn_QL.setBounds(272, 10, 100, 27);
		btn_QL.addActionListener(ac);
		frame.getContentPane().add(btn_QL);
	}
	public void Inform() {
		JOptionPane.showMessageDialog(frame, "Password is not correct!", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void Note() {
		JOptionPane.showMessageDialog(frame, "Please enter the password", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	public void Error() {
		JOptionPane.showMessageDialog(frame, "Password is Error", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void Anouces() {
		JOptionPane.showMessageDialog(frame, "You is registered", "Anouces", JOptionPane.OK_OPTION);
	}
}
