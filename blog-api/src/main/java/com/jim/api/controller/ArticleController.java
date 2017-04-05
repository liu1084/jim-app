package com.jim.api.controller;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.dto.vilidator.ArticleDTOValidator;
import com.jim.api.model.entity.BlogArticlesEntity;
import com.jim.api.service.generator.ArticleInfoGenerator;
import com.jim.controller.BaseController;
import com.jim.api.service.IArticleService;
import com.jim.response.APIResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jim on 2017/2/22.
 * This class is ...
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
	@Autowired
	private IArticleService articleService;

	@Autowired
	private ArticleDTOValidator validator;

	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	public APIResponse save(@ModelAttribute("article") ArticleDTO articleDTO, BindingResult result){
		validator.validate(articleDTO, result);
		if (result.hasErrors()){
			return APIResponse.toErrorResponse(result);
		}
		BlogArticlesEntity entity = ArticleInfoGenerator.generate(articleDTO);
		articleService.save(entity);
		return APIResponse.toOkResponse(articleDTO);
	}

	@RequestMapping(value= {"", "/"}, method = RequestMethod.GET)
	public APIResponse index(){
		List articlesEntityList = articleService.read();
		return APIResponse.toOkResponse(gson.toJson(articlesEntityList));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public APIResponse getArticleById(@PathVariable Long id){
		BlogArticlesEntity article = articleService.getArticleById(id);;
		return APIResponse.toOkResponse(gson.toJson(article));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public APIResponse delete(@PathVariable Long id){
		BlogArticlesEntity entity = articleService.getArticleById(id);
		if (entity == null){
			return APIResponse.toErrorResponse("article is not existed by id:" + id);
		}
		articleService.delete(id);
		return APIResponse.toOkResponse(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public APIResponse update(@PathVariable Long id, @ModelAttribute("article") ArticleDTO articleDTO, BindingResult result){
		BlogArticlesEntity entity = articleService.getArticleById(id);
		if (entity == null){
			return APIResponse.toErrorResponse("article is not existed by id:" + id);
		}
		validator.validate(articleDTO, result);
		if (result.hasErrors()){
			return APIResponse.toErrorResponse(result);
		}
		BlogArticlesEntity newEntity = ArticleInfoGenerator.generate(articleDTO, entity);
		articleService.update(newEntity);
		return APIResponse.toOkResponse(articleDTO);
	}
}
