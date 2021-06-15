package com.booth.web.controller;

import com.booth.web.common.model.R;
import com.booth.web.service.IServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ExceptionController
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/06/20:23
 * @Description: //TODO
 */
@RestController
public class ExceptionController {

	@Autowired
	private IServiceException iServiceException;

	@GetMapping(value = "/getService")
	public R getExceptionForService(){

		String serviceException = iServiceException.getServiceException();
		System.out.println(serviceException+"serviceException");
		return R.OK();
	}
}
