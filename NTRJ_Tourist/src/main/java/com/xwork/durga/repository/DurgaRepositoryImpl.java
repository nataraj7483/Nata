package com.xwork.durga.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.catalina.Manager;
import org.hibernate.validator.internal.util.privilegedactions.GetMethodFromGetterNameCandidates;
import org.springframework.stereotype.Repository;

import com.xwork.durga.entity.DurgaEntity;

@Repository
public class DurgaRepositoryImpl implements DurgaRepository{
	
	private EntityManagerFactory entityManagerFactory;
	
	public DurgaRepositoryImpl() {
		System.out.println("Crested"+ getClass().getTypeName());
	}
	
	public boolean save(DurgaEntity entity) {
		System.out.println("Running save in repository");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entity);
		entityTransaction.commit();
		entityManager.close();
		return true;
		
	}
	public DurgaEntity findById(int id) {
		System.out.println("Find by id in repo"+id);
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        DurgaEntity entity= entityManager.find(DurgaEntity.class, id);
        entityManager.close();
        return entity;
	}
	public List<DurgaEntity> findByUserName(String userName){
		System.out.println("find by userName in repo"+userName);
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		try {
			Query query= entityManager.createNamedQuery("findByUserName");
			query.setParameter("userName", userName);
			System.out.println("query"+query);
			List<DurgaEntity> list=query.getResultList();
			System.out.println("total List found in repo"+list.size());
			return list;
		}
		finally{
			entityManager.close();
		}
	}
	public List<DurgaEntity> findByEmail(String email){
		System.out.println("find By email in repo"+email);
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			Query query= entityManager.createNamedQuery("findByEmail");
			query.setParameter("query", query);
			System.out.println("query"+query);
			List<DurgaEntity> list=query.getResultList();
			System.out.println("total list found in repo"+list.size());
			return list;
		}
		finally {
			entityManager.close();
			System.out.println("Released the connection");
		}
	}
	public boolean update(DurgaEntity entity) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(entity);
			entityTransaction.commit();
			return true;
		}
		finally {
			entityManager.close();
		}
		
	}
	public DurgaEntity deletById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			DurgaEntity durgaEntity=entityManager.find(DurgaEntity.class, id);
			entityTransaction.begin();
			entityManager.remove(durgaEntity);
		entityTransaction.commit();
		return durgaEntity;
		}
		finally {
			entityManager.close();
		}
	}
	
	

}
