package myfirstjob.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import myfirstjob.dto.HrUser;
import myfirstjob.dto.JobseekerUser;

public class JobseekerService {
	public boolean saveJobseeker(JobseekerUser jsUser) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
		entityTransaction.begin();
		entityManager.persist(jsUser);
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
	public JobseekerUser getJobseeker(String email,String password) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		TypedQuery<JobseekerUser> jsData=entityManager.createQuery("from JobseekerUser where email=:email and password=:password ",JobseekerUser.class);
		jsData.setParameter("email", email);
		jsData.setParameter("password", password);
		JobseekerUser record =jsData.getSingleResult();
		return record;	
	}


}
