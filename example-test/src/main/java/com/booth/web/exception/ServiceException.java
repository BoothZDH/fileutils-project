package com.booth.web.exception;

import com.booth.web.erroCode.CodeMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ServiceException
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/06/20:01
 * @Description: //TODO
 */
@Data
public class ServiceException extends RuntimeException {
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
