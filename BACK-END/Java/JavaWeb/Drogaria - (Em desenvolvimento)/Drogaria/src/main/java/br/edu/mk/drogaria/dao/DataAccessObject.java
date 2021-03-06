package br.edu.mk.drogaria.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.mk.drogaria.util.HibernateUtil;

/**
 * 
 * @author Maikon
 *
 * @param <T>
 * @param <I>
 */
public class DataAccessObject <T, I extends Serializable> {
	
	private Class<T> entityClass;
	
	public DataAccessObject(){}
	
	public DataAccessObject(Class<T> entityClass){
		this.entityClass = entityClass;
	}
	
	/**
	 * Method for save Object
	 * 
	 * @param object
	 * @return void
	 */
	public void save(T object){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.save(object);
			transaction.commit();
		}catch(Exception exception){
			if(transaction != null)
				transaction.rollback();
			
			throw exception;
		}finally{
			session.close();
		}
	}
	
	/**
	 * Method for update object
	 * 
	 * @param object
	 * @return void
	 */
	public void update(T object){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.update(object);
			transaction.commit();
		}catch(Exception exception){
			if(transaction != null)
				transaction.rollback();
			
			throw exception;
		}finally{
			session.close();
		}
	}
	
	/**
	 * Method for merge Object
	 * 
	 * @param object
	 * @return void
	 */
	public void merge(T object){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.merge(object);
			transaction.commit();
		}catch(Exception exception){
			if(transaction != null)
				transaction.rollback();
			
			throw exception;
		}finally{
			session.close();
		}
	}
	
	/**
	 * Method for delete object 
	 * 
	 * @param object
	 * @return void
	 */
	public void delete(T object){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.delete(object);
			transaction.commit();
		}catch(Exception exception){
			if(transaction != null)
				transaction.rollback();
			
			throw exception;
		}finally{
			session.close();
		}
	}
	
	/**
	 * Method for delete from identifier
	 * 
	 * @param identifier
	 * @return void
	 */
	public void delete(I identifier){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
	
		try{
			transaction = session.beginTransaction();	
			session.delete(session.find(entityClass, identifier));
			transaction.commit();
		}catch(Exception exception){
			if(transaction != null)
				transaction.rollback();
			
			throw exception;
		}finally{
			session.close();
		}
	}
	
	/**
	 * Method for search object from identifier
	 * 
	 * @param identifier
	 * @return T
	 */
	public T search(I identifier){
		Session session = HibernateUtil.getSessionFactory().openSession();
		T object = null;
		
		try{
			object = session.find(entityClass, identifier);
		}catch(Exception exception){
			throw exception;
		}finally{
			session.close();
		}
		
		return object;
	}
	
	/**
	 * Method for search all
	 * 
	 * @return List<T>
	 */
	public List<T> findAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<T> listObject = null;
		
		try{
			CriteriaBuilder c = session.getCriteriaBuilder();
			CriteriaQuery<T> query = c.createQuery(entityClass);
			query.from(entityClass);
			listObject = session.createQuery(query).getResultList();
			
		}catch(Exception exception){
			
		}finally{
			session.close();
		}
		
		return listObject;
	}
}