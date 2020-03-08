package myfirstjob.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import myfirstjob.dto.ApplyDetails;
import myfirstjob.dto.Job;
import myfirstjob.dto.JobSeekerProfile;
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
		try {
		JobseekerUser record =jsData.getSingleResult();
		return record;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public boolean addProfile(JobSeekerProfile profile) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
		entityTransaction.begin();
		entityManager.persist(profile);
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
	
	public JobSeekerProfile findProfile(Integer jobseekerId) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		TypedQuery<JobSeekerProfile> jsData=entityManager.createQuery("from JobSeekerProfile where JobseekerUser_id=:id ",JobSeekerProfile.class);
		jsData.setParameter("id", jobseekerId);
		try {
		JobSeekerProfile profile=jsData.getSingleResult();
		return profile;
		}
		catch(Exception e) {
			return null;
		}
		
	}

	public List<Job> getJobList(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		TypedQuery<Job> jobsList=entityManager.createQuery("from Job",Job.class);
		return jobsList.getResultList();
		
	}
	public boolean applyJob(ApplyDetails apply) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobportal");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
		entityTransaction.begin();
		entityManager.persist(apply);
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
