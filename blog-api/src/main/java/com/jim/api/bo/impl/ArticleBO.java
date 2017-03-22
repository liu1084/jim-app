package com.jim.api.bo.impl;

import com.jim.api.bo.IArticleBO;
import com.jim.api.dao.IArticleDAO;
import com.jim.api.entities.blog.BlogArticlesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
@Service
public class ArticleBO implements IArticleBO {
	@Autowired
	private IArticleDAO articleDAO;

	@Override
	public void save(BlogArticlesEntity articlesEntity) {
		articleDAO.save(articlesEntity);
	}

	@Override
	public List read() {
		return articleDAO.read();
	}

	@Override
	public List getArticleById(long id) {
		return articleDAO.getArticleById(id);
	}
}
