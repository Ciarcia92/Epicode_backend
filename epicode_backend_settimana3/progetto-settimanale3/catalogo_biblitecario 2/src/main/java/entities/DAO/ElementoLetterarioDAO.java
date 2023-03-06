package entities.DAO;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.ElementoLetterario;
import util.JpaUtil;

public class ElementoLetterarioDAO {

	private static final Logger logger = LoggerFactory.getLogger(ElementoLetterarioDAO.class);

	public void save(ElementoLetterario object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Errore nel salvataggio dell' oggetto: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	public void refresh(ElementoLetterario object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public ElementoLetterario getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(ElementoLetterario.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(ElementoLetterario object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Errore nell'eliminazione dell'oggetto: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}
	}

	public void deleteByIsbn(int ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createNamedQuery("DELETE e FROM ElementoLetterario e WHERE e.isbn = :ISBN");

			query.setParameter("isbn", ISBN);

			query.executeUpdate();

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Errore nell'eliminazione dell' oggeto con ISBN:  " + ISBN, ex);
			throw ex;

		} finally {
			em.close();
		}
	}

	public List<ElementoLetterario> getByTitle(String titolo) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			Query query = em.createNamedQuery("getByTitle");

			query.setParameter("titolo", titolo);

			return query.getResultList();
	
		} finally {
			em.close();
		}

	}
	public List<ElementoLetterario> getByIsbn(int ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			
			Query query = em.createNamedQuery("getByIsbn");
			
			query.setParameter("isbn", ISBN);
			
			return query.getResultList();
			

		} finally {
			em.close();
		}
		
	}
	public List<ElementoLetterario> getByAuthor(String autore) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			
			Query query = em.createNamedQuery("getByIsbn");
			
			query.setParameter("autore", autore);
			
			return query.getResultList();
	
		} finally {
			em.close();
		}
		
	}
	public List<ElementoLetterario> getByYear(String annoPubblicazione) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			
			Query query = em.createNamedQuery("getByYear");
			
			query.setParameter("anno", annoPubblicazione);
			
			return query.getResultList();
			
	
		} finally {
			em.close();
		}
		
	}

}
