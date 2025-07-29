package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Register {
	private String tenDangNhap;
	@Id
	private String matKhau;
	private String hoTen;
	private Date ngaySinh;
	private Date ngayDangKy;
	private String sdt;
	private String diaChi;
	public Register() {
		
	}
	public Register(String tenDangNhap, String matKhau, String hoTen, Date ngaySinh, Date ngayDangKy, String sdt,
			String diaChi) {
		
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.ngayDangKy = ngayDangKy;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgayDangKy() {
		return ngayDangKy;
	}
	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
}
