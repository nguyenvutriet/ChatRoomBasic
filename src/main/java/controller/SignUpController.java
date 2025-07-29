package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.UIManager;

import dao.registerDAO;
import model.Register;
import util.HibernateUtil_;
import view.SignIn;
import view.SignUp;

public class SignUpController implements ActionListener{
	private SignUp view;
	private registerDAO re;
	

	public SignUpController(SignUp view) {
		
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = e.getActionCommand();
		if(button.equals("Sign Up")) {
			re = new registerDAO();
			String maKhau = view.tF_Password.getText();
			String tenDangNhap = view.tF_user.getText();
			String hoTen = view.name;
			String diaChi = view.tF_Address.getText();
			String sdt = view.tF_Phone.getText();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate time = LocalDate.parse(view.JT_DateOfBirth.getText(), formatter);
			Date ngaySinh = Date.valueOf(time);
			
			DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDate times = LocalDate.parse(view.time, formatter_1);
			Date ngayDangKy = Date.valueOf(times);
			
			if(re.checkExist(maKhau, hoTen, tenDangNhap)) {
				view.Faild();
			}else {
				if(re.insert(new Register(tenDangNhap, maKhau, hoTen, ngaySinh, ngayDangKy, sdt, diaChi))) {
					view.Inform();
					
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						SignIn signIn = new SignIn(view.name);
						signIn.frame.setVisible(true);
						view.frame.dispose();
					} catch (Exception e2) {
						// TODO: handle exception
						HibernateUtil_.writeFileLong(e2.getMessage());
					}
				}else {
					view.Faild();
					view.reset();
				}
			}
		}else if(button.equals("Clean")) {
			view.reset();
		}
	}

}
