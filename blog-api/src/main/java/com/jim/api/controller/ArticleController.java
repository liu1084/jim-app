package com.jim.api.controller;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.api.model.dto.vilidator.ArticleDTOValidator;
import com.jim.api.model.entity.BlogArticlesEntity;
import com.jim.api.service.generator.ArticleInfoGenerator;
import com.jim.controllers.BaseController;
import com.jim.api.service.IArticleService;
import com.jim.response.APIResponse;
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

	@RequestMapping(value = "/create", method = RequestMethod.POST, headers = {JSON_API_CONTENT_HEADER})
	public APIResponse save(@ModelAttribute("article") ArticleDTO articleDTO, BindingResult result){
		validator.validate(articleDTO, result);
		if (result.hasErrors()){
			return APIResponse.toErrorResponse(result);
		}

		BlogArticlesEntity entity = ArticleInfoGenerator.generate(articleDTO);
		articleService.save(entity);
		return APIResponse.toOkResponse(articleDTO);

	}

	@RequestMapping(value= {"", "/"})
	public String index(){
		List articlesEntityList = articleService.read();
		return gson.toJson(articlesEntityList);
	}

	@RequestMapping(value = "/{id}")
	public String getArticleById(@PathVariable Long id){
		BlogArticlesEntity article = articleService.getArticleById(id);;
		return gson.toJson(article);
	}

	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST, headers = {JSON_API_CONTENT_HEADER})
	public String addArticle(@RequestBody ArticleDTO articleDTO){
		return gson.toJson(new ArrayList<>());
	}
}
