package com.jim.api.model.repository.impl;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.entity.BlogArticlesEntity;
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
public class ArticleRepository extends BaseHibernateJPARepository implements IArticleRepository {
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
	public List<BlogArticlesEntity> read() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BlogArticlesEntity";
		return session.createQuery(hql).list();
	}

	@Transactional
	public BlogArticlesEntity getArticleById(long id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM BlogArticlesEntity AS t1 WHERE t1.id=:id";
		BlogArticlesEntity entity = (BlogArticlesEntity) session.createQuery(hql).setParameter("id", id).uniqueResult();
		return entity;
	}

	@Override
	@Transactional
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		BlogArticlesEntity entity = getArticleById(id);
		entity.setStatus(BlogArticlesEntity.ArticleStatus.DELETE);
		session.update(entity);
	}
}
