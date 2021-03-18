package com.booth.staticClass;

/**
 * @ClassName: MainClass
 * @Description:TODO
 * @Version:1.0
 */
public class MainClass {
	public static void main(String[] args) {
		//1.
		Class clazz1 = Base.class;
		System.out.println("...");
		//2.
		try {
			Class clazz2 = Class.forName("com.booth.staticClass.Base");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
