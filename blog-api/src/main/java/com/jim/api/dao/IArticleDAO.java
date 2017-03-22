package com.jim.api.dao;

import com.jim.api.entities.blog.BlogArticlesEntity;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
public interface IArticleDAO {
	void save(BlogArticlesEntity articlesEntity);
	List read();
	List getArticleById(long id);
}
