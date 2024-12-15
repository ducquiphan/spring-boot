package com.ducpq.demo.myspringbootapp.playload.response;

import com.ducpq.demo.myspringbootapp.util.ResponseUtil;
import org.springframework.http.HttpStatus;

public record RestResponse<T>(int status, String code, String message, T data) {
	public static <T> RestResponse<T> ok(String code, T data) {
		return new RestResponse<>(HttpStatus.OK.value(), code, ResponseUtil.getMassageBundle((code)), data);
	}
	
	public static <T> RestResponse<T> created(String code, T data) {
		return new RestResponse<>(HttpStatus.CREATED.value(), code, ResponseUtil.getMassageBundle((code)), data);
	}
	
	public static <T> RestResponse<T> accepted(String code, T data) {
		return new RestResponse<>(HttpStatus.ACCEPTED.value(), code, ResponseUtil.getMassageBundle((code)), data);
	}
	
	public static <T> RestResponse<T> ok(String code, String message, T data) {
		return new RestResponse<>(HttpStatus.OK.value(), code, message, data);
	}
	
	public static <T> RestResponse<T> created(String code, String message, T data) {
		return new RestResponse<>(HttpStatus.CREATED.value(), code, message, data);
	}
	
	public static <T> RestResponse<T> accepted(String code, String message, T data) {
		return new RestResponse<>(HttpStatus.ACCEPTED.value(), code, message, data);
	}
}
