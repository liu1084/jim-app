package com.jim.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * Created by jim on 2017/2/22.
 * This class is ...
 */
@Controller
public class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(BaseController.class);
	protected GsonBuilder gsonBuilder = new GsonBuilder();
	protected Gson gson = gsonBuilder.create();
}
