package com.booth.common.exceptionUtils;

import com.baomidou.mybatisplus.extension.api.R;
import com.booth.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: ExceptionHandlerAdvice
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/15/15:00
 * @Description: //TODO
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {


	@ExceptionHandler(value = ServiceException.class)
	@ResponseBody
	public Result<?> serviceExceptionHandler(HttpServletRequest request, HttpServletResponse response, ServiceException ex) {
		ex.printStackTrace();
		return Result.error(ex.getMessage());
	}
}
