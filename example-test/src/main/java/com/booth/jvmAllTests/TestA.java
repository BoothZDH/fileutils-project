package com.booth.jvmAllTests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: TestA
 * @Description:TODO
 * @Version:1.0
 */


public class TestA {
	String  name;

	String   age;



	@Override
	public String toString() {
		return "TestA{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}
