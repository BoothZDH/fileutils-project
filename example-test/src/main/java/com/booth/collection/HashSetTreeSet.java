package com.booth.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

/**
 * @ClassName: HashSetTreeSet
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
public class HashSetTreeSet {







	@Test
	public void testLongestCommonPrefix(){
		String[] strs = new String[]{
				"booth","borth","booth"
		};
		String prefix = longestCommonPrefix(strs);
		System.out.println(prefix);
	}

	/**
	 * MaxPrefix of a String[]
	 * @param strs
	 * @return
	 */
	private String longestCommonPrefix(String[] strs) {
		String orign = strs[0];
		if (strs.length == 0){
			return "";
		}
		for (String str : strs){
			while (!str.startsWith(orign)){
				if (orign.length() == 0){
					return "";
				}
				orign = orign.substring(0,orign.length()-1);
			}
		}

		return orign;

	}


	private static BigDecimal result = new BigDecimal(3);

	@Test
	public void testRomanToInt(){
		String str = "-XX";
		int res = romanToInt(str);
		System.out.println(str+" ->RomanToInt ->"+res);
	}

	public int romanToInt(String s){
		HashMap<String,Integer> hm = new HashMap<String, Integer>();
		hm.put("I",1);
		hm.put("V",5);
		hm.put("X",10);
		hm.put("L",50);
		hm.put("C",100);
		hm.put("D",500);
		hm.put("M",1000);
		int res = 0;
		char ch;
		if (s.length()<=0){
			return 0;
		}
		char c = s.charAt(s.length() - 1);
		Integer lowlevel  = hm.get(Character.toString(c));

		if (s.length() ==1 ){
			return  lowlevel;
		}
		for (int i = s.length()-1; i >=0; i--) {
			ch = s.charAt(i);
			Integer highLevel = hm.get(Character.toString(ch));
			if (highLevel == null){
				return res;
			}
			res = lowlevel > highLevel ? (res - highLevel):(res + highLevel);
			lowlevel = highLevel;
		}
		return res;
	}


	@Test
	public void testm() {
		Runnable r = ()->{
			result = result.add(result);
		};

		Thread ad = new Thread(r);
		ad.start();

		try {
			ad.join();
		} catch (InterruptedException e) {
			log.error("in here...");
		}

		System.out.println(result);

	}


	public Runnable MyThread() {
		Runnable r = () -> {
			System.out.println("thread create...");
		};
		return r;
	}

	@Test
	public void testThreads() {
		Runnable rb = MyThread();
		Thread thread = new Thread(rb, "run 1 thread...");
		log.info("threa begin startting.....");
		thread.start();

	}


	@Test
	public void testOrder() {
		HashSet<Integer> haset = new HashSet<>();
		haset.add(3);
		haset.add(7);
		haset.add(2);
		haset.add(81);


		System.out.println((haset.stream()
				.map(x -> toString())
				.collect(Collectors.joining(","))));
	}


	/**
	 * 更有效的两数之和算法
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] outIndex = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				outIndex[1] = i;
				outIndex[0] = hm.get(nums[i]);
				return outIndex;
			}
			hm.put(target - nums[i], i);
		}
		return null;
	}

//	public int[] twoSum(int[] nums, int target) {
//		int[] outIndex = new int[2];
//		for(int  i = 0 ; i < nums.length ; i++ ){
//			for(int j = i+1;j<nums.length ; j++){
//				if(target == nums[i] + nums[j]){
//					System.out.println(nums[i] +"+"+nums[j] +"="+target);
//					outIndex[0] = i;
//					outIndex[1] = j;
//					return outIndex;
//				}
//			}
//		}
//		return null;
//	}

	@Test
	public void testTwoSum() {
		int[] nums = new int[]{1, 2, 5, 6, 7, 4, 0, 5, 7, 10};
		int target = 10;
		int[] ints = twoSum(nums, target);
		System.out.println("[" + ints[0] + "," + ints[1] + "]");
	}


	/**
	 * 反转整数
	 *
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		Long ret = 0L;
		Boolean flag = true;
		while (flag) {
			ret = ret * 10 + x % 10;
			x = x / 10;
			if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
				return 0;
			}
			if (x == 0) {
				flag = false;
			}
		}
		return ret.intValue();
	}

	public int reverse1(int x) {
		long n = 0;
		while (x != 0) {
			n = n * 10 + x % 10;
			x = x / 10;
		}
		return (int) n == n ? (int) n : 0;
	}

	public int reverse2(int x) {
		int ret = 0;
		while (x != 0) {
			int tem = ret;
			ret = ret * 10 + x % 10;
			x = x / 10;
			ret = ret / 10 == tem ? ret : 0;
		}
		return ret;
	}

	@Test
	public void testReverse() {
		int num = 223;
		int reverseNum = reverse2(num);
		System.out.println("num:" + num + "  ~ " + "reverseNum:" + reverseNum);
	}

	public boolean isPalindrome(int x) {
		String str = Integer.toString(x);
		String sub = str.substring(0, str.length() / 2);
		if (x < 0) {
			return false;
		}
		for (int i = 0; i < str.length() / 2; i++) {
			char ch = str.charAt(i);
			log.info(Character.toString(ch));
			char ch1 = str.charAt(str.length() - 1 - i);
			log.info(Character.toString(ch1));

			if (ch != ch1) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testIsPalindrome() {
		int num = 12;
		boolean palindrome = isPalindrome(num);
		System.out.println(palindrome);

	}
}
