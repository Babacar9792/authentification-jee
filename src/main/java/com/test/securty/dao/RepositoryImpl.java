package com.test.securty.dao;



import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.securty.config.HibernateUtil;

public class RepositoryImpl<T> implements IRepository<T> {
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	private Logger log = LoggerFactory.getLogger(RepositoryImpl.class);
	
	
	@Override
	public boolean save(T t) {
		try {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			return true;
		} catch (Exception e2) {
			log.info("Erreur lors de l'ajout des données");
			log.warn(e2.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(long id,T t) {
				
		try {
			transaction = session.beginTransaction();
			session.delete(session.get(t.getClass(), id));
			transaction.commit();
			return true;
		} catch (Exception e2) {
			log.info("Erreur lors de la suppression des données");
			log.warn(e2.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(T t) {
		try {
			transaction = session.beginTransaction();
			session.merge(t);
			transaction.commit();
			return true;
		} catch (Exception e2) {
			log.info("Erreur lors de la mise à jours des données");
			log.warn(e2.getMessage());
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(T t) {
		//log.info("getSession"+HibernateUtil.getSessionFactory().toString());
       CriteriaBuilder cb = session.getCriteriaBuilder();
      
       CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(t.getClass());
       Root<T> root = (Root<T>) cq.from(t.getClass());
       							cq.select(root);
       log.info("Récupération de la liste");
       return session.createQuery(cq).getResultList();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get (long id,T t) {
		
        return (T) session.get(t.getClass(), id);
	}

	
}
