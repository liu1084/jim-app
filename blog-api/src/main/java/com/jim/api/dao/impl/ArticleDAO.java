package com.jim.api.dao.impl;

import com.jim.api.dao.IArticleDAO;
import com.jim.api.entities.blog.BlogArticlesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
@Repository
public class ArticleDAO implements IArticleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void save(BlogArticlesEntity articlesEntity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(articlesEntity);
	}

	@Transactional
	public List read() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BlogArticlesEntity";
		return session.createQuery(hql).list();
	}

	@Transactional
	public List getArticleById(long id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BlogArticlesEntity AS t1 WHERE t1.id=?";
		return session.createQuery(hql).setParameter(0, id).list();
	}
}
