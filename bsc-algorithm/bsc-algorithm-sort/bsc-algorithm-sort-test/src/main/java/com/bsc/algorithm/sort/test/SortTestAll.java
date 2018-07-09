package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.bubble.BubbleSort;
import com.bsc.algorithm.sort.heap.HeapSort;
import com.bsc.algorithm.sort.inf.ISort;
import com.bsc.algorithm.sort.insert.InsertSort;
import com.bsc.algorithm.sort.merge.MergeSort;
import com.bsc.algorithm.sort.quick.QuickSort;
import com.bsc.algorithm.sort.select.SelectSort;
import com.bsc.algorithm.sort.shell.ShellSort;

public class SortTestAll {

	public static void main(String[] args) {
		Integer[] data = ArrayGenerator.random(Integer[].class, 20000, 0, 20000);
//		Integer[] data = ArrayGenerator.seq(Integer[].class, 10000, 10000, -1);
		Integer[] insertData = Arrays.copyOf(data, data.length);
		Integer[] selectData = Arrays.copyOf(data, data.length);
		Integer[] shellData = Arrays.copyOf(data, data.length);
		Integer[] bubbleData = Arrays.copyOf(data, data.length);
		Integer[] mergeData = Arrays.copyOf(data, data.length);
		Integer[] quickData = Arrays.copyOf(data, data.length);
		Integer[] heapData = Arrays.copyOf(data, data.length);
		
		ISort<Integer> sort = new InsertSort<>();
		long start = System.currentTimeMillis();
//		System.out.println(Arrays.toString(insertData));
		sort.sortAsc(insertData);
		System.out.println("²åÈë:" + (System.currentTimeMillis() - start));
		
		sort = new SelectSort<>();
		start = System.currentTimeMillis();
//		System.out.println(Arrays.toString(selectData));
		sort.sortAsc(selectData);
		System.out.println("Ñ¡Ôñ:" + (System.currentTimeMillis() - start));
		
		sort = new ShellSort<>();
		start = System.currentTimeMillis();
//		System.out.println(Arrays.toString(shellData));
		sort.sortAsc(shellData);
		System.out.println("Ï£¶û:" + (System.currentTimeMillis() - start));
		
		sort = new BubbleSort<>();
		start = System.currentTimeMillis();
//		System.out.println(Arrays.toString(bubbleData));
		sort.sortAsc(bubbleData);
		System.out.println("Ã°ÅÝ:" + (System.currentTimeMillis() - start));
		
		sort = new MergeSort<>();
		start = System.currentTimeMillis();
//		System.out.println(Arrays.toString(mergeData));
		sort.sortAsc(mergeData);
		System.out.println("¹é²¢:" + (System.currentTimeMillis() - start));
		
		sort = new QuickSort<>();
		start = System.currentTimeMillis();
//		System.out.println(Arrays.toString(quickData));
		sort.sortAsc(quickData);
		System.out.println("¿ìËÙ:" + (System.currentTimeMillis() - start));
		
		sort = new HeapSort<>();
		start = System.currentTimeMillis();
//		System.out.println(Arrays.toString(heapData));
		sort.sortAsc(heapData);
		System.out.println("¶Ñ:" + (System.currentTimeMillis() - start));
		
	}
}
