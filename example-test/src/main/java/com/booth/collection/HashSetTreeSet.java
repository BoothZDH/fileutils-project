package com.booth.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: HashSetTreeSet
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
public class HashSetTreeSet {


	@Test
	public  void testOrder(){
		HashSet<Integer> haset = new HashSet<>();
		haset.add(3);
		haset.add(7);
		haset.add(2);
		haset.add(81);


		System.out.println((haset.stream()
				.map(x -> toString())
				.collect(Collectors.joining(","))));
	}
}
