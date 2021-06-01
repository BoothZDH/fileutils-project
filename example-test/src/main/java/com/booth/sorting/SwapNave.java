package com.booth.sorting;

/**
 * @ClassName: SwapNave
 * @Description:TODO
 * @Version:1.0
 */
public class SwapNave {
	static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
