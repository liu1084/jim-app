package com.jim.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jim.gson.SuperclassExclusionStrategy;
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
	private GsonBuilder gsonBuilder = new GsonBuilder()
			.addDeserializationExclusionStrategy(new SuperclassExclusionStrategy())
			.addSerializationExclusionStrategy(new SuperclassExclusionStrategy())
			.excludeFieldsWithoutExposeAnnotation();
	protected Gson gson = gsonBuilder.create();

	protected static final String JSON_API_CONTENT_HEADER = "Content-type=application/json";
}
