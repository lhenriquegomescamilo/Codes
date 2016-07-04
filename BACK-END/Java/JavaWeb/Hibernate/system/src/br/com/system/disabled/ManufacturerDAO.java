package br.com.system.disabled;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.system.domain.Manufacturer;
import br.com.system.util.HibernateUtil;

/**
 * 
 * @author Maikon
 *
 */

public class ManufacturerDAO {

	/**
	 * Method for save manufacturer 
	 * 
	 * @param Manufacturer
	 * @return void
	 */
	public void save(final Manufacturer manufacturer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(manufacturer);
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
	 * Method for update manufacturer 
	 * 
	 * @param manufacturer
	 * @return void
	 */
	public void update(final Manufacturer manufacturer){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.update(manufacturer);
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
	public void delete(final Long identifier) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(session.load(Manufacturer.class, identifier));
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
	 * Method for delete manufacturer
	 * 
	 * @param manufacturer
	 * @return void
	 */
	public void delete(final Manufacturer manufacturer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(manufacturer);
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
	 * Method for search all manufacturers 
	 * 
	 * @param void
	 * @return List<Manufacturer>
	 * @throws Exception
	 */
	public List<Manufacturer> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Manufacturer> manufacturers = null;

		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Manufacturer> query = builder.createQuery(Manufacturer.class);
			query.from(Manufacturer.class);
			manufacturers = session.createQuery(query).getResultList();
		} catch (Exception exception) {
			throw exception;
		} finally {
			session.close();
		}

		return manufacturers;
	}

	
	/**
	 * Method for search manufacturer from identifier
	 * 
	 * @param identifier
	 * @return Manufacturer
	 */
	public Manufacturer search(final Long identifier) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Manufacturer manufacturer = null;

		try {
			manufacturer = session.find(Manufacturer.class, identifier);
		} catch (Exception exception) {
			throw exception;
		} finally {
			session.close();
		}

		return manufacturer;
	}
	
	
}
