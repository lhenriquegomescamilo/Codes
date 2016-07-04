package br.com.sistema.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistema.domain.Employee;
import br.com.sistema.util.HibernateUtil;

/**
 * 
 * @author Maikon
 *
 */

public class EmployeeDAO{
	
	/**
	 * Method for save employee.
	 * 
	 * @param employee
	 * @return void
	 */
	public void save(final Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (Exception exception) {
			if (transaction != null)
				transaction.rollback();

			throw exception;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Method for update employee
	 * 
	 * @param employee
	 * @return void
	 */
	public void update(final Employee employee){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.update(employee);
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
	 * Method for search employee from identifier
	 * 
	 * @param identifier
	 * @return Employee
	 */
	public Employee search(final Long identifier){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = null;
		
		try{
			employee = session.find(Employee.class, identifier);
		}catch(Exception exception){
			throw exception;
		}finally{
			session.close();
		}
		
		return employee;
	}
	

	/**
	 * Method for search all officials
	 * 
	 * @param void
	 * @return List<Funcionario>
	 */
	public List<Employee> findAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> officials = null;
		
		try{
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			query.from(Employee.class);
			officials = session.createQuery(query).getResultList();
			
		}catch(Exception exception){
			throw exception;
		}finally{
			session.close();
		}
		
		return officials;
	}
	
	/**
	 * Method for delete employee from identifier
	 * 
	 * @param identifier
	 * @return void
	 */
	public void delete(final Long identifier){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.delete(session.load(Employee.class, identifier));
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
	 * Method for delete employee
	 * 
	 * @param employee
	 * @return void
	 */
	public void delete(final Employee employee){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
	
		try{
			transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
		}catch(Exception exception){
			if(transaction != null)
				transaction.rollback();
			
			throw exception;
		}finally{
			session.close();
		}	
	}
}
