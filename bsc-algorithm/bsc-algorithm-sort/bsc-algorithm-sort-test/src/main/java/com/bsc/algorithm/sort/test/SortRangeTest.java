package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.inf.ISort;
import com.bsc.algorithm.sort.select.SelectSort;

public class SortRangeTest {

	public static void main(String[] args) {
		Integer[] data = ArrayGenerator.random(Integer[].class, 20, 0, 99);
		System.out.println("ԭ��:" + Arrays.toString(data));
		ISort<Integer> sort = new SelectSort<>();
		sort.sortAsc(data, 1, 18);
		System.out.println("����:" + Arrays.toString(data));
		sort.sortDesc(data, 1, 18);
		System.out.println("����:" + Arrays.toString(data));
	}
}
