package com.jim.api.controllers;

import com.jim.api.model.dto.ArticleDTO;
import com.jim.controllers.BaseController;
import com.jim.api.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	private IArticleService articleBO;

	@RequestMapping(value= {"", "/"})
	public String index(){
		List articlesEntityList = articleBO.read();
		return gson.toJson(articlesEntityList);
	}

	@RequestMapping(value = "/{id}")
	public String getArticleById(@PathVariable Long id){
		List articles = new ArrayList();
		if (id == null) return gson.toJson(articles);
		articles = articleBO.getArticleById(id);
		return gson.toJson(articles);
	}

	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST, headers = {JSON_API_CONTENT_HEADER})
	public String addArticle(@RequestBody ArticleDTO articleDTO){
		return gson.toJson(new ArrayList<>());
	}
}