package com.booth.web.service.impl;

import com.booth.web.erroCode.CodeMapping;
import com.booth.web.exception.ServiceException;
import com.booth.web.service.IServiceException;
import org.springframework.stereotype.Service;

/**
 * @ClassName: IServiceExceptionImpl
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/06/20:27
 * @Description: //TODO
 */
@Service
public class IServiceExceptionImpl implements IServiceException {
	@Override
	public String getServiceException() {
		String str = "exception";
		if (str.equals("exception")){
			throw new ServiceException(CodeMapping.ERROR_PARAM,"service层异常抛出");
		}

		return str;
	}
}
