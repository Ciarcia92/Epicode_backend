 package entities.DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.ElementoLetterario;
import entities.Prestito;
import util.JpaUtil;

public class PrestitoDAO {
	private static final Logger logger = LoggerFactory.getLogger(PrestitoDAO.class);

	public void save(Prestito object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	public void refresh(Prestito object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public Prestito getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Prestito.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(Prestito object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}
	public List<Prestito> getByExpiredLoan() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			
			Query query = em.createNamedQuery("SELECT p FROM prestito WHERE p.data_restituzione_prevista < data_corrente AND p. data_restituzione_effettiva IS NULL");
			
			query.setParameter("data_corrente", LocalDate.now());
			
			return query.getResultList();
			
		
		} finally {
			em.close();
		}
		
	}
}
