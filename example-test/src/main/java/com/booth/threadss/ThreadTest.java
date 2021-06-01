package com.booth.threadss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: ThreadTest
 * @Description:TODO
 * @Version:1.0
 */
public class ThreadTest {

	@Test
	public void test1() throws ExecutionException, InterruptedException {

		FutureTask futureTask = new FutureTask<>(new MyThread());
		ArrayList<Object> list = new ArrayList<>();


		Thread thread = new Thread(futureTask, "1线程");

		System.out.println(thread.getName());
		thread.start();

		System.out.println(futureTask.get());


	}
}
