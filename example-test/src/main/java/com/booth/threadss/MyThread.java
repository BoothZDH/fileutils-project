package com.booth.threadss;

import com.booth.sorting.SelectSort;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.concurrent.Callable;

/**
 * @ClassName: MyThread
 * @Description:TODO
 * @Version:1.0
 */
public class MyThread implements Callable {
	@Override
	public Object call() throws Exception {
		int[] arr = new int[]{1,3,4,55,6,333,44};
		SelectSort selectSort = new SelectSort();
		StringBuilder stringBuilder = new StringBuilder();

		selectSort.sort(arr);

		for (int i = 0; i <arr.length ; i++) {
			System.out.println(arr[i]+i);
			stringBuilder.append(arr[i]);
		}

		return stringBuilder.toString();
	}
}
