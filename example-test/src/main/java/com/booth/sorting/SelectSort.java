package com.booth.sorting;

import org.junit.Test;

/**
 * @ClassName: SelectSort
 * @Description:TODO
 * @Version:1.0
 */
public class SelectSort {

	public void sort(int[] a){
		for (int i = a.length-1; i >=0 ; i--) {
			int j = maxIndex(a,i,i+1);
			SwapNave.swap(a,i,j);

		}
	}


	static int maxIndex(int[] a,int i,int j){
		int max = Integer.MIN_VALUE;

		int maxIndex = i;
		for (int k =0;k<j;k++){
			if (max < a[k]) {
				max = a[k];
				maxIndex = k;
			}
		}
		return maxIndex;
	}



}
