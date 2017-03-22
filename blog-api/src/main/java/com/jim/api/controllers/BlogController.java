package com.jim.api.controllers;

import com.jim.api.BaseController;
import com.jim.api.bo.IArticleBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 2017/2/22.
 * This class is ...
 */
@Controller(value = "/blog/article")
public class BlogController extends BaseController {
	@Autowired
	private IArticleBO articleBO;

	@RequestMapping(value= {"", "/"})
	@ResponseBody
	public String index(){
		List articlesEntityList = articleBO.read();
		return gson.toJson(articlesEntityList);
	}

	@RequestMapping(value = "/{id}")
	@ResponseBody
	public String getArticleById(@PathVariable Long id){
		List articles = new ArrayList();
		if (id == null) return gson.toJson(articles);
		articles = articleBO.getArticleById(id);
		return gson.toJson(articles);
	}
}
