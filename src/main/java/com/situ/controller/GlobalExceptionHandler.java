package com.situ.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.situ.utils.ExceptionUtil;

/**
 * 全局统一异常处理
 * 
 * @author 浅墨~~
 * @date 2021年12月23日
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ModelAndView handleException(Exception exception) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("global/error");
		mav.addObject("title", exception.getMessage());
		mav.addObject("error", "异常了");
		mav.addObject("popup", true);
		// 异常堆栈信息
		mav.addObject("exception", ExceptionUtil.exceptionToString(exception));
		return mav;
	}

//	@ExceptionHandler
//	public String handleException1(Exception exception, Map<String, Object> map) {
//
//		map.put("title", exception.getMessage());
//		map.put("error", "IO异常了");
//		map.put("popup", true);
//		// 异常堆栈信息
//		map.put("exception", ExceptionUtil.exceptionToString(exception));
//		return "global/error";
//	}

}
