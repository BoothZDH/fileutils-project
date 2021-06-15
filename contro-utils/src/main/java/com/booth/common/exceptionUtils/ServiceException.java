package com.booth.common.exceptionUtils;

/**
 * @ClassName: ServiceException
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/15/15:00
 * @Description: //TODO
 */
public class ServiceException extends RuntimeException{
	private int code;
	private String message;


	public ServiceException(int code) {
		this.code = code;
		this.message = CodeMapping.getMessage(code);
	}

	public ServiceException(int code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
}
