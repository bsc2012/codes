package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.inf.ISort;
import com.bsc.algorithm.sort.select.SelectSort;

public class Test {

	public static void main(String[] args) {
		int[] array = ArrayGenerator.randomInt(10, 1, 100);
		ISort sort = new SelectSort();
		System.out.println(Arrays.toString(array));
		sort.sortAsc(array);
		System.out.println(Arrays.toString(array));
		sort.sortDesc(array);
		System.out.println(Arrays.toString(array));
		
		
/*		long total = 0;
		ISort sort = new InsertSort();
		for(int i = 0;i < 1000;i++){
			int[] array = ArrayGenerator.randomInt(1000, 1, 10000);
			long start = System.currentTimeMillis();
			sort.sortAsc(array);
			total += System.currentTimeMillis() - start;
		}
		System.out.println("²åÈëÅÅÐòºÄÊ±:" + total);
		
		total = 0;
		sort = new ShellSort();
		for(int i = 0;i < 1000;i++){
			int[] array = ArrayGenerator.randomInt(1000, 1, 10000);
			long start = System.currentTimeMillis();
			sort.sortAsc(array);
			total += System.currentTimeMillis() - start;
		}
		System.out.println("Ï£¶ûÅÅÐòºÄÊ±:" + total);*/
	}
}
