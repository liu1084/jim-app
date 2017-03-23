package com.jim.api.model.repository.impl;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.entity.BlogArticlesIEntity;
import com.jim.api.model.repository.IArticleRepository;
import com.jim.repository.impl.BaseHibernateJPARepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
@Repository
public class ArticleRepository extends BaseHibernateJPARepository<BlogArticlesIEntity, Long> implements IArticleRepository {
	private static final Logger logger = LoggerFactory.getLogger(ArticleRepository.class);
	@Autowired
	private SessionFactory sessionFactory;

	@PostConstruct
	public void setup(){
		logger.info("Article Repository was created...");
	}

	@Transactional
	public void save(ArticleDTO articlesEntity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(articlesEntity);
	}

	@Transactional
	public List read() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BlogArticlesIEntity";
		return session.createQuery(hql).list();
	}

	@Transactional
	public List<BlogArticlesIEntity> getArticleById(long id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BlogArticlesIEntity AS t1 WHERE t1.id=?";
		return session.createQuery(hql).setParameter(0, id).list();
	}

	@Override
	@Transactional
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		BlogArticlesIEntity entity = getArticleById(id).get(0);
		session.delete(entity);
	}
}
