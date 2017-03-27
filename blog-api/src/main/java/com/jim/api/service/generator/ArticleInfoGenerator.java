package com.jim.api.service.generator;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.entity.BlogArticlesEntity;

/**
 * Created by jim on 2017/3/28.
 * This class is ...
 */
public class ArticleInfoGenerator {
	public static BlogArticlesEntity generate(ArticleDTO dto){
		BlogArticlesEntity entity = new BlogArticlesEntity();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setBackground(dto.getBackground());
		entity.setCommentStatus(BlogArticlesEntity.ArticleCommentStatus.OPEN);

		return entity;
	}
}
