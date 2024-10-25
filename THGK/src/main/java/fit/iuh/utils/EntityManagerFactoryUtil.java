package fit.iuh.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
//	public static void main(String[] args) {
//		EntityManager entityManager = Persistence.createEntityManagerFactory("management").createEntityManager();
//	}
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("management");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEnManager() {
		return this.entityManager;
	}
	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
