package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.inf.ISort;
import com.bsc.algorithm.sort.quick.QuickSort;

public class Test {

	public static void main(String[] args) {
		int[] array = ArrayGenerator.randomInt(10, 0, 99);
		Integer[] data = new Integer[array.length];
		for(int i = 0;i < array.length;i++){
			//data[i] = (char)('a' + array[i]);
			data[i] = array[i];
		}
		
		ISort<Integer> sort = new QuickSort<Integer>();
		System.out.println("ԭ��:" + Arrays.toString(data));
		sort.sortAsc(data);
		System.out.println("����:" + Arrays.toString(data));
		sort.sortDesc(data);
		System.out.println("����:" + Arrays.toString(data));
		
		
/*		long total = 0;
		ISort sort = new InsertSort();
		for(int i = 0;i < 1000;i++){
			int[] array = ArrayGenerator.randomInt(1000, 1, 10000);
			long start = System.currentTimeMillis();
			sort.sortAsc(array);
			total += System.currentTimeMillis() - start;
		}
		System.out.println("���������ʱ:" + total);
		
		total = 0;
		sort = new ShellSort();
		for(int i = 0;i < 1000;i++){
			int[] array = ArrayGenerator.randomInt(1000, 1, 10000);
			long start = System.currentTimeMillis();
			sort.sortAsc(array);
			total += System.currentTimeMillis() - start;
		}
		System.out.println("ϣ�������ʱ:" + total);*/
	}
}
