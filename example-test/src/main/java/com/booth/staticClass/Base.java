package com.booth.staticClass;

/**
 * @ClassName: Base
 * @Description:TODO
 * @Version:1.0
 */

/**
 * 静态代码块初始化问题--类加载
 */
public class Base {
	static int num = 1;
	static {
		System.out.println("Base"+num);
	}
}
