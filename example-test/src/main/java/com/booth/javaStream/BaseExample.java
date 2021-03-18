package com.booth.javaStream;

import org.junit.Test;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: BaseExample
 * @Description:TODO
 * @Version:1.0
 */
public class BaseExample {

	@Test
	public void test1(){

		List<String> lists = new ArrayList<>();
		lists.add("I love my honey");
		lists.add("her name is xin xin");
		lists.add("she is very cute");
		lists.add("and");
		lists.add("and");


		lists.stream()
				.map((ll) -> ll.split(","))
				.flatMap(Arrays::stream)
				.collect(Collectors.toSet())
				.forEach((x)-> System.out.println(x));
//				.distinct()
//				.count();
	}

	@Test
	public void test2(){
		Stream.iterate(1, (x) -> x + 1)
				.limit(100)
				.filter((num) -> num % 2 == 0)
				.collect(Collectors.toCollection(ArrayList::new))
				.forEach((x)-> System.out.println(x));

	}




}
