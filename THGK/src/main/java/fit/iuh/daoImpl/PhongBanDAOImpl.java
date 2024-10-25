package fit.iuh.daoImpl;

import java.util.List;

import fit.iuh.dao.PhongBanDAO;
import fit.iuh.models.PhongBan;
import jakarta.persistence.EntityManager;

public class PhongBanDAOImpl implements PhongBanDAO{
	private EntityManager entityManager;
	
	public PhongBanDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<PhongBan> findAll() {
		try {
			return entityManager.createQuery("From PhongBan").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
