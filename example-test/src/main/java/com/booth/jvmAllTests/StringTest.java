package com.booth.jvmAllTests;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: StringTest
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
public class StringTest {
	public static void main(String[] args) {
//		String s = new String("1");
//		s.intern();
//		String s2 = "1";
//		System.out.println(System.identityHashCode(s));
//		System.out.println(System.identityHashCode(s2));
//
//		System.out.println(s==s2);
//
//		String s3 = new String("1") + new String("1");
//		s3.intern();
//		String s4 = "11";
//		System.out.println(System.identityHashCode(s3));
//		System.out.println(System.identityHashCode(s4));
//
//		System.out.println(s3==s4);

//
//
//
//		String a = "a";
//		String b = "a";
//		System.out.println(a==b);

		// Java中的占位符使用，，%s,%c,
//		String str = "string";
//		Character s = 's';
//		log.info("%s : {}",str);
//		log.info("%c : {}",s);
//		log.info(String.format("%c",s));
//		log.info(String.format("%s",str));

		List<TestA> l = new ArrayList<>();
		TestA testA = new TestA();
		TestA testB = new TestA();
		TestA testc = new TestA();
		testA.setAge(12);
		testA.setName("yy");
		testB.setAge(14);
		testB.setName("jj");
		testc.setAge(15);
		testc.setName("ll");

		l.add(testA);
		l.add(testB);
		l.add(testc);

		l.stream().filter(t -> t.getAge() > 13).collect(Collectors.toList())
				.forEach(t-> System.out.println(JSONObject.toJSONString(t)) );

		log.info("-----------------");
		l.stream().filter(t -> t.getAge() < 13).collect(Collectors.toList())
				.forEach(t-> System.out.println(JSONObject.toJSONString(t)) );
	}



	public  static  void test1(){



		TestA testA = new TestA();
		testA.name = "sss";
		System.out.println(testA.name);
		//System.out.println(JSONObject.toJSON(testA));


		TestA testB = new TestA();
		testB.name = "222222";
		System.out.println(testA.name);
		System.out.println(testB);
		String string = JSONObject.toJSONString(testA);
		System.out.println(JSONObject.toJSONString(testA));
	}


}
