package myfirstjob.service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import myfirstjob.dto.HrUser;
import myfirstjob.dto.Job;

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
	
	public List<Job> getJobs(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		TypedQuery<Job> jobList= entityManager.createQuery("from Job where HrUser_id=:id",Job.class);
		jobList.setParameter("id", id);
		List<Job> list=jobList.getResultList();
		return list;
		
	}
	
	public boolean addJob(Job job) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(job);
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
}
