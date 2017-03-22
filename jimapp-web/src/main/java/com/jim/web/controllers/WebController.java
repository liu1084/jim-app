package com.jim.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
//https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
@Controller
public class WebController extends WebBaseController {
	@RequestMapping(value = {"/", ""})
	public String index(Model model) {
		model.addAttribute("message", "hello");
		model.addAttribute("name", "jim");
		return "index";
	}
}
