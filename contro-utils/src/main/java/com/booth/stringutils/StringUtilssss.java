package com.booth.stringutils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import java.util.HashMap;

/**
 * @ClassName: StringUtilssss
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
public class StringUtilssss {

	private static String bo = "booth_zhongdognhua";


	public static void main(String[] args) {
		stringMethods();
		//isEqual();

		HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
	}



	public static void stringMethods(){
		//获取指定位置字符
		char ch = bo.charAt(3);
		System.out.println(ch);

		//
		int i = bo.codePointAt(3);
		System.out.println(i);
	}





	/**
	 * 确认“”和null是否一样  ---> 不同，
	 */
	public static void   isEqual(){
		String str = "";
		String strs = null;
		if (str.equals(strs)){
			log.info("str ==null");
			return;
		}
		if (!str.equals(null)){
			try {
				int length = strs.length();
				System.out.println("null:"+length);
			}catch(Exception e){
				String message = e.getMessage();
				log.info(message);
			}

		}
		if (!"".equals(null)){
			log.info("{\"json\""+":"+"\"value\"}");
			return;
		}



	}
}
