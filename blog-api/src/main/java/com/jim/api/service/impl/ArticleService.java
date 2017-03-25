package com.jim.api.service.impl;

import com.jim.api.model.entity.BlogArticlesEntity;
import com.jim.api.service.IArticleService;
import com.jim.api.model.repository.IArticleRepository;
import com.jim.api.model.dto.ArticleDTO;
import com.jim.service.impl.BaseJPAServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
@Service
public class ArticleService extends BaseJPAServiceImpl implements IArticleService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private IArticleRepository articleRepository;

	@Override
	@PostConstruct
	public void setupService() {
		logger.info("setting up categoryService...");
		this.baseJpaRepository = articleRepository;
		this.clazz = ArticleService.class;
		this.baseJpaRepository.setupEntityClass(ArticleService.class);
		logger.info("categoryService created...");
	}

	@Override
	public void save(ArticleDTO articlesEntity) {
		articleRepository.save(articlesEntity);
	}

	@Override
	public List<BlogArticlesEntity> read() {
		return articleRepository.read();
	}

	@Override
	public BlogArticlesEntity getArticleById(long id) {
		return articleRepository.getArticleById(id);
	}

	@Override
	public void delete(long id) {
		BlogArticlesEntity entity = articleRepository.getArticleById(id);
		articleRepository.delete(entity);
	}

}
