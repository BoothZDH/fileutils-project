package com.booth.web.erroCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CodeMapping
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/06/20:03
 * @Description: //TODO
 */
public  abstract class CodeMapping {

	public static Integer SUCCESS = 0;
	public static Integer ERROR_PARAM = 10000;
	public static Integer ERROR_PARAM_SIGN = 10001;
	public static Integer ERROR_AUTH = 20000;
	public static Integer ERROR_BUSINESS = 30000;
	public static Integer ERROR_SYSTEM = 40000;
	public static Integer ERROR_LACK_COUPON = 30001;
	public static Integer ERROR_CLR_BANK_API = 50001;


	public static Integer ERROR_API = 60000;
	public static Integer ERROR_NETWORK = 70000;


	public static String CODE_STRING_SUCCESS = "success";
	public static String CODE_STRING_ERROR_PARAM = "请求参数错误";
	public static String CODE_STRING_ERROR_PARAM_SIGN = "数据签名错误";
	public static String CODE_STRING_ERROR_AUTH = "认证权限错误";
	public static String CODE_STRING_ERROR_BUSINESS = "业务处理错误";
	public static String CODE_STRING_ERROR_SYSTEM = "系统错误";
	public static String CODE_STRING_ERROR_CLR_BANK_API = "银行接口错误";

	public static String getMessage(Integer code) {
		if (MAPPER.containsKey(code)) {
			return MAPPER.get(code);
		} else {
			return "错误码未定义！";
		}
	}

	private static Map<Integer, String> MAPPER = new HashMap<Integer, String>() {{
		put(0, "success");
		/****参数类错误****/
		put(10000, "请求参数错误");
		put(10001, "数据签名错误");

		/****权限类错误****/
		put(20000, "认证权限错误");
		put(20001, "账号不存在");
		put(20002, "用户名密码不正确");
		put(20003, "账号被锁定");

		/****业务处理类错误****/
		put(30000, "业务处理错误");

		/****系统类错误****/
		put(40000, "系统错误");


	}};
}
