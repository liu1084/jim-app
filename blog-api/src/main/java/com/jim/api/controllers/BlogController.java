package com.jim.api.controllers;

import com.jim.api.BaseController;
import org.springframework.stereotype.Controller;

/**
 * Created by jim on 2017/2/22.
 * This class is ...
 */
@Controller(value = "/blog")
public class BlogController extends BaseController {
	public String index(){
		return "blog/index";
	}
}
