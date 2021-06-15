package com.booth.web.aop;

import com.booth.web.common.model.R;
import com.booth.web.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: ControllerExceptionAdive
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/06/20:06
 * @Description: //TODO 全局异常处理类
 */
@ControllerAdvice
public class ControllerExceptionAdive {

	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public R serviceExceptionHandler(HttpServletRequest request,
	                                 HttpServletResponse response,
	                                 ServiceException se){
		se.getMessage();
		return R.fail(se.getCode(),se.getMessage());
	}
}
