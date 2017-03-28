package com.jim.api.controller;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.dto.vilidator.ArticleDTOValidator;
import com.jim.api.model.entity.BlogArticlesEntity;
import com.jim.api.service.generator.ArticleInfoGenerator;
import com.jim.controllers.BaseController;
import com.jim.api.service.IArticleService;
import com.jim.response.APIResponse;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST, headers = {JSON_API_CONTENT_HEADER})
	//http://www.raistudies.com/spring/spring-mvc/ajax-form-validation-using-spring-mvc-and-jquery/
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

	@RequestMapping(value = "/{id}")
	public APIResponse getArticleById(@PathVariable Long id){
		BlogArticlesEntity article = articleService.getArticleById(id);;
		return APIResponse.toOkResponse(gson.toJson(article));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public APIResponse delete(@PathVariable Long id){
		if (StringUtils.isNotEmpty(String.valueOf(id))){
			articleService.delete(id);
			return APIResponse.toOkResponse(id);
		}
		return APIResponse.toErrorResponse("id is required");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = {JSON_API_CONTENT_HEADER})
	public APIResponse update(@PathVariable String id, @ModelAttribute("article") ArticleDTO articleDTO, BindingResult result){
		validator.validate(articleDTO, result);
		if (result.hasErrors()){
			return APIResponse.toErrorResponse(result);
		}
		BlogArticlesEntity entity = ArticleInfoGenerator.generate(articleDTO);
		articleService.update(Long.parseLong(id), entity);
		return APIResponse.toErrorResponse("id is required");
	}
}
