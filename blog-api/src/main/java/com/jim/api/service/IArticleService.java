package com.jim.api.service;

import com.jim.api.model.dto.ArticleDTO;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
public interface IArticleService {
	void save(ArticleDTO articlesEntity);
	List read();
	List getArticleById(long id);
	void delete(long id);
}
