package com.jim.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.servlet.ModelAndView;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Created by jim on 2017/3/26.
 * This class is ...
 */
@JsonInclude(NON_NULL)
public class APIResponse {
	public static final String API_RESPONSE = "apiResponse";
	Object result;
	String time;
	Long code;

	public static final Integer RESPONSE_OK_CODE = 200;
	public static final Integer RESPONSE_ERR_CODE = 500;
	public static final Integer RESPONSE_EXCEPTION_CODE = 600;

	public static class ExceptionAPIResponse extends APIResponse {
		Object details;

		public Object getDetails() {
			return details;
		}

		public void setDetails(Object details) {
			this.details = details;
		}
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public static APIResponse toOkResponse(Object data) {
		return toAPIResponse(data, RESPONSE_OK_CODE);
	}

	public static APIResponse toErrorResponse(Object data) {
		return toAPIResponse(data, RESPONSE_ERR_CODE);
	}

	public static ExceptionAPIResponse toExceptionResponse(String result, Object details) {
		ExceptionAPIResponse response = new ExceptionAPIResponse();
		response.setResult(result);
		response.setDetails(details);
		response.setCode(RESPONSE_EXCEPTION_CODE);
		return response;
	}

	public APIResponse withModelAndView(ModelAndView modelAndView) {
		modelAndView.addObject(API_RESPONSE, this);
		return this;
	}

	public static APIResponse toAPIResponse(Object data, long code) {
		APIResponse response = new APIResponse();
		response.setResult(data);
		response.setCode(code);
		return response;
	}
}
