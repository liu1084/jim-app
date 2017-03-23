package com.jim.repository.impl;

import com.jim.entity.IEntity;
import com.jim.repository.IBaseJPARepository;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jim on 2017/3/23.
 * This class is ...
 */
public abstract class BaseHibernateJPARepository<T extends IEntity, ID extends Serializable> implements IBaseJPARepository<T, ID> {
	@Autowired
	protected SessionFactory sessionFactory;

	Session session;
	protected Class<T> clazz;


	@Override
	public void setupEntityClass(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	@Transactional
	public T insert(T object) {
		session = sessionFactory.getCurrentSession();
		session.setHibernateFlushMode(FlushMode.AUTO);
		session.save(object);
		session.flush();
		return object;
	}

	@Override
	@Transactional
	public T update(T object) {
		session = sessionFactory.getCurrentSession();
		session.setHibernateFlushMode(FlushMode.AUTO);
		session.update(object);
		session.flush();
		return object;
	}

	@Override
	@Transactional
	public T insertOrUpdate(T object) {
		session = sessionFactory.getCurrentSession();
		session.setHibernateFlushMode(FlushMode.AUTO);
		session.saveOrUpdate(object);
		session.flush();
		return object;
	}

	@Override
	@Transactional
	public void delete(T object) {
		session = sessionFactory.getCurrentSession();
		session.delete(object);
	}

	@Override
	public T findById(ID id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		criteria.setMaxResults(countPerPage);
		criteria.setFirstResult(pageNum * countPerPage);
		return criteria.list();
	}
}
