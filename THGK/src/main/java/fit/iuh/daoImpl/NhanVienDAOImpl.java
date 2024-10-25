package fit.iuh.daoImpl;

import java.util.List;

import fit.iuh.dao.NhanVienDAO;
import fit.iuh.models.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class NhanVienDAOImpl implements NhanVienDAO{
	private EntityManager entityManager;
	
	public NhanVienDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<NhanVien> findAll() {
		try {
			return entityManager.createQuery("Select nv From NhanVien nv JOIN Fetch nv.phongBan", NhanVien.class).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NhanVien addNhanVien(NhanVien nv) {
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(nv);
			transaction.commit();
			return nv;
		}catch (Exception e) {
			e.printStackTrace();
			if(transaction!=null && transaction.isActive())
				transaction.rollback();
		}
		return null;
	}


	@Override
	public boolean xoaNhanVien(int id) {
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			NhanVien nv = entityManager.find(NhanVien.class, id);
			if(nv != null) {
				entityManager.remove(entityManager.contains(nv) ? nv : entityManager.merge(nv));
			}
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			if(transaction!=null && transaction.isActive())
				transaction.rollback();
		}
		return false;
	}

}
