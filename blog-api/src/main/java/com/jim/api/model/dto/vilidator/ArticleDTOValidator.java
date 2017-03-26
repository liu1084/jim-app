package com.jim.api.model.dto.vilidator;

import com.jim.api.model.dto.ArticleDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by jim on 2017/3/27.
 * This class is ...
 */
@Component
public class ArticleDTOValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return ArticleDTO.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ArticleDTO articleDTO = (ArticleDTO) o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content is required");
	}
}
