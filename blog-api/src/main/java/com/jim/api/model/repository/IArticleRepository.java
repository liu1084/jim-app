package com.jim.api.model.repository;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.entity.BlogArticlesIEntity;
import com.jim.repository.IBaseJPARepository;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
public interface IArticleRepository extends IBaseJPARepository {
	void save(ArticleDTO articlesEntity);
	List read();
	List<BlogArticlesIEntity> getArticleById(long id);
	void delete(long id);
}
