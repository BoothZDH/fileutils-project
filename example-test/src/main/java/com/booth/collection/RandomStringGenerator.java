package com.booth.collection;

import lombok.experimental.var;

import java.util.*;
import java.util.function.Consumer;

import static org.mockito.internal.progress.SequenceNumber.next;

/**
 * @ClassName: RandomStringGenerator
 * @Description:TODO
 * @Version:1.0
 */
public class RandomStringGenerator<T> implements Iterable<T> {

	private final List<T> list;

	public RandomStringGenerator(List<T> list) {
		this.list = list;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public T next() {
				return list.get((int) (list.size() * Math.random()));
			}
		};
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("List", "Array", "Tree");
		RandomStringGenerator<String> strings = new RandomStringGenerator<>(list);

//		for (String string : strings) {
//			System.out.println(string);
//		}

		Iterator<String> iterator = strings.iterator();
		for (int i = 0; i < 100; i++) {
			String s = iterator.next();
			System.out.println(i + 1 + s);
		}




	}

}
