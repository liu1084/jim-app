package com.jim.api.service.generator;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.entity.BlogArticlesEntity;

/**
 * Created by jim on 2017/3/28.
 * This class is ...
 */
public class ArticleInfoGenerator {
	public static BlogArticlesEntity generate(ArticleDTO dto) {
		BlogArticlesEntity entity = new BlogArticlesEntity();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setBackground(dto.getBackground());
		entity.setUserId(dto.getUserId());
		entity.setStatus(getArticleStatus(dto.getStatus()));
		entity.setCommentStatus(getArticleCommentStatus(dto.getCommentStatus()));
		entity.setCommentCount(dto.getCommentCount());
		return entity;
	}

	private static BlogArticlesEntity.ArticleStatus getArticleStatus(String s) {
		BlogArticlesEntity.ArticleStatus status;
		switch (s) {
			case "0":
				status = BlogArticlesEntity.ArticleStatus.DELETE;
				break;
			case "1":
				status = BlogArticlesEntity.ArticleStatus.PRIVATE;
				break;
			case "2":
				status = BlogArticlesEntity.ArticleStatus.PUBLIC;
				break;
			case "3":
				status = BlogArticlesEntity.ArticleStatus.DRAFT;
				break;
			default:
				status = BlogArticlesEntity.ArticleStatus.DRAFT;

		}
		return status;
	}

	private static BlogArticlesEntity.ArticleCommentStatus getArticleCommentStatus(String s) {
		BlogArticlesEntity.ArticleCommentStatus status = BlogArticlesEntity.ArticleCommentStatus.OPEN;
		//TODO!!
		return status;
	}

	private static BlogArticlesEntity.ArticleSticky getArticleSticky(String s){
		BlogArticlesEntity.ArticleSticky sticky = BlogArticlesEntity.ArticleSticky.NORMAL;
		//TODO!!
		return sticky;
	}
}
