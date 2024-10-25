package fit.iuh.dao;

import java.util.List;

import fit.iuh.models.NhanVien;

public interface NhanVienDAO {
	public List<NhanVien> findAll();
	public NhanVien addNhanVien(NhanVien nv);
	public boolean xoaNhanVien(int id);
}
