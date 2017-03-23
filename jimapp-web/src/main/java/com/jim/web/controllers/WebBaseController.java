package com.jim.web.controllers;

import com.jim.controllers.BaseController;
import com.jim.web.exception.ResourceNotFoundException;
import com.jim.web.exception.ServiceFaultHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jim on 2017/3/22.
 * This class is ...
 */
@Controller
public class WebBaseController extends BaseController {
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFoundException(){
		logger.error("page not found");
		return "errors/error-404";
	}
	@ExceptionHandler(ServiceFaultHandle.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public String handle500Exception(){
		logger.error("service is unavailable");
		return "errors/error-50x";
	}
}
