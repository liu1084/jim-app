package com.jim.api.model.repository;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.entity.BlogArticlesEntity;
import com.jim.repository.IBaseJPARepository;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
public interface IArticleRepository extends IBaseJPARepository {
	void save(BlogArticlesEntity articlesEntity);
	List<BlogArticlesEntity> read();
	BlogArticlesEntity getArticleById(long id);
	void update(BlogArticlesEntity articlesEntity);
	void delete(long id);
}
