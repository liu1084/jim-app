package com.jim.api.controllers;

import com.jim.api.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jim on 2017/2/22.
 * This class is ...
 */
@Controller(value = "/blog")
public class BlogController extends BaseController {
	@RequestMapping(value="index")
	public String index(){

		logger.debug("get all blog");
		return "";

	}
}
