package com.test.securty.dao;

import com.test.securty.entity.UserEntity;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.securty.config.HibernateUtil;

public class UserDao extends RepositoryImpl<UserEntity> implements IUserDao{
	
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	private Logger log = LoggerFactory.getLogger(UserDao.class);
	

	@Override
	public Optional<UserEntity> login(String email, String password) {

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cr = cb.createQuery(UserEntity.class);
		Root<UserEntity> user = cr.from(UserEntity.class);
		//Predicate pour la clause where
		Predicate predicateEmail = cb.equal(user.get("email"), email);
		Predicate predicatePwd = cb.equal(user.get("password"), password);
		Predicate finalPredicate = cb.and(predicateEmail, predicatePwd);
		
		cr.select(user);
		cr.where(finalPredicate);
		
		// try {
			return Optional.ofNullable(session.createQuery(cr).getSingleResult());
		// } catch (Exception e) {
		// 	log.info("Login : erreur lors de la tentative de login");
		// 	log.warn(e.getMessage());
		// 	return Optional.empty();
		// 	// TODO: handle exception
		// }
	}

}
