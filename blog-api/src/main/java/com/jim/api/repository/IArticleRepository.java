package com.jim.api.repository;

import com.jim.api.dto.ArticleDTO;
import com.jim.api.entities.blog.BlogArticlesEntity;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
public interface IArticleRepository {
	void save(ArticleDTO articlesEntity);
	List read();
	List<BlogArticlesEntity> getArticleById(long id);
	void delete(long id);
}
