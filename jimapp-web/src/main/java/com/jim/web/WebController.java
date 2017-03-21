package com.jim.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
@Controller
public class WebController {
	@RequestMapping(value = {"/", ""})
	public String index(Model model) {
		model.addAttribute("message", "hello");
		model.addAttribute("name", "jim");
		return "index";
	}

	@RequestMapping(value = "/error")
	public String error(Model model) {
		model.addAttribute("message", "page not found...");
		return "error";
	}
}
