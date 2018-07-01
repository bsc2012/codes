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

public class SortRangeTest {

	public static void main(String[] args) {
		Integer[] data = ArrayGenerator.random(Integer[].class, 35, 10, 99);
		System.out.println(Arrays.toString(data));
		
		ISort<Integer> sort = new BubbleSort<>();
		sort.sortAsc(data, 0, 4);
		System.out.println(Arrays.toString(data));
		
		sort = new HeapSort<>();
		sort.sortAsc(data, 5, 9);
		System.out.println(Arrays.toString(data));
		
		sort = new InsertSort<>();
		sort.sortAsc(data, 10, 14);
		System.out.println(Arrays.toString(data));
		
		sort = new MergeSort<>();
		sort.sortAsc(data, 15, 19);
		System.out.println(Arrays.toString(data));
		
		sort = new QuickSort<>();
		sort.sortAsc(data, 20, 24);
		System.out.println(Arrays.toString(data));
		
		sort = new SelectSort<>();
		sort.sortAsc(data, 25, 29);
		System.out.println(Arrays.toString(data));
		
		sort = new ShellSort<>();
		sort.sortAsc(data, 30, 34);
		System.out.println(Arrays.toString(data));
	}
}
