package myfirstjob.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import myfirstjob.dto.HrUser;

public class HrService {
	public boolean saveHr(HrUser hrUser) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
		entityTransaction.begin();
		entityManager.persist(hrUser);
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		return true;
		} catch(Exception e){
			e.printStackTrace();
			entityTransaction.rollback();
			return false;
		}
	}
	public HrUser getHr(String email,String password) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		TypedQuery<HrUser> hrData=entityManager.createQuery("from HrUser where email=:email and password=:password ",HrUser.class);
		hrData.setParameter("email", email);
		hrData.setParameter("password", password);
		HrUser record =hrData.getSingleResult();
		return record;	
	}
}
