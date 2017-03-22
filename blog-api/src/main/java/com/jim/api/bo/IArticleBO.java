package com.jim.api.bo;

import com.jim.api.entities.blog.BlogArticlesEntity;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
public interface IArticleBO {
	void save(BlogArticlesEntity articlesEntity);
	List read();
	List getArticleById(long id);
}
