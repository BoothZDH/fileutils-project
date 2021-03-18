package com.booth.utils;


import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: TimeUtil
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
public class TimeUtil {

	/**
	 * Date 格式化并转为字符串
	 * @param date
	 * @return
	 */
	public static String   dateToString(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
		String dateType = dateFormat.format(date);
		return dateType;
	}

	/**
	 * 字符串转日期格式"yyyy-MM-dd"
	 */
	public static Date StringToDate(String stringTime) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(stringTime);
		return date;
	}

	/**
	 * 毫秒转日期格式"yyyy-MM-dd"
	 */

	public static Date MileToDate(Long mileTime){
		Date date = new Date();
		date.setTime(mileTime);
		return date;

	}

	/**
	 * 日期格式转毫秒值
	 * @param date
	 * @return
	 */
	public static Long  dateToMile(Date date){
		long dateTime = date.getTime();
		return dateTime;
	}
	/**
	 * 获取年月日
	 */


	/**
	 * 获取时间
	 */

	/**
	 * 获取。。。
	 */

}
