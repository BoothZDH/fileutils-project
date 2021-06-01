package com.booth.sorting;

import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.EAN;
import org.junit.Test;
import sun.swing.BakedArrayList;

import java.lang.reflect.*;
import java.util.*;

/**
 * @ClassName: SortingTest
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
public class SortingTest {

	@Test
	public void selectTest1(){
		int[] a = new int[]{1,3,5,33,66,4,33,2,5,77,888,43};
		SelectSort selectSort = new SelectSort();
		selectSort.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+i);
		}
	}


	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("booth");
		list.add("zhong");
		list.add("joni");
		list.add("losi");
		list.add("rosi");
		list.add("sang");

		ListIterator<String> stringListIterator = list.listIterator();
		while (stringListIterator.hasNext()){

			String next = stringListIterator.next();
			System.out.println(next);
		}

		stringListIterator.add("add string");
		System.out.println(list.contains("add string"));


	}

}
