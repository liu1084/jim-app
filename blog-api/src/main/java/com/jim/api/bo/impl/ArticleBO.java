package com.jim.api.bo.impl;

import com.jim.api.bo.IArticleBO;
import com.jim.api.repository.IArticleRepository;
import com.jim.api.dto.ArticleDTO;
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
	private IArticleRepository articleDAO;

	@Override
	public void save(ArticleDTO articlesEntity) {
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

	@Override
	public void delete(long id) {
		ArticleDTO articleDTO = (ArticleDTO) getArticleById(id).get(0);

	}
}
