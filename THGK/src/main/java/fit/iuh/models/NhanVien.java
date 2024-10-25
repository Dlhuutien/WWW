package fit.iuh.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNhanVien;
	private String tenNV;
	private String email;
	private String diaChi;
	private String dienThoai;

	@ManyToOne
	@JoinColumn(name = "maPhongBan")
	private PhongBan phongBan;

	public NhanVien() {
		super();
	}

	public NhanVien(int maNhanVien, String tenNV, String email, String diaChi, String dienThoai, PhongBan phongBan) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNV = tenNV;
		this.email = email;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.phongBan = phongBan;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

}
