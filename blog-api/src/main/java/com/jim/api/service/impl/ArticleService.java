package com.jim.api.service.impl;

import com.jim.api.model.dto.vilidator.ArticleDTOValidator;
import com.jim.api.model.entity.BlogArticlesEntity;
import com.jim.api.service.IArticleService;
import com.jim.api.model.repository.IArticleRepository;
import com.jim.api.model.dto.ArticleDTO;
import com.jim.response.APIResponse;
import com.jim.service.impl.BaseJPAServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
@Service
public class ArticleService extends BaseJPAServiceImpl implements IArticleService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private IArticleRepository articleRepository;

	@Autowired
	private ArticleDTOValidator validator;

	@Override
	@PostConstruct
	public void setupService() {
		logger.info("setting up categoryService...");
		this.baseJpaRepository = articleRepository;
		this.clazz = ArticleService.class;
		this.baseJpaRepository.setupEntityClass(ArticleService.class);
		logger.info("categoryService created...");
	}

	@Override
	public APIResponse save(ArticleDTO articleDTO) {
		BlogArticlesEntity entity = new BlogArticlesEntity();
		articleRepository.save(articleDTO);
		return APIResponse.toOkResponse(entity);
	}

	private APIResponse validDTO(@ModelAttribute("ArticleDTO") ArticleDTO articleDTO, BindingResult result, SessionStatus sessionStatus){
		validator.validate(articleDTO, result);
		if (result.hasErrors()){
			return APIResponse.toErrorResponse(result);
		}
		sessionStatus.setComplete();
		return APIResponse.toOkResponse(articleDTO);
	}


	@Override
	public List<BlogArticlesEntity> read() {
		return articleRepository.read();
	}

	@Override
	public BlogArticlesEntity getArticleById(long id) {
		return articleRepository.getArticleById(id);
	}

	@Override
	public void delete(long id) {
		BlogArticlesEntity entity = articleRepository.getArticleById(id);
		articleRepository.delete(entity);
	}

}
