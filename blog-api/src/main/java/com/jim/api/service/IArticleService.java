package com.jim.api.service;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.entity.BlogArticlesEntity;
import com.jim.response.APIResponse;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
public interface IArticleService {
	void save(BlogArticlesEntity articlesEntity);
	List<BlogArticlesEntity> read();
	BlogArticlesEntity getArticleById(long id);
	void update(BlogArticlesEntity entity);
	void delete(long id);
}