package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.heap.HeapSort;
import com.bsc.algorithm.sort.inf.ISort;
import com.bsc.algorithm.sort.select.SelectSort;

public class SortTest {

	public static void main(String[] args) {
		ISort<Integer> sortInt = new SelectSort<Integer>();

		Integer[] dataInt = ArrayGenerator.random(Integer[].class, 10, 0, 99);
		System.out.println("ԭ��:" + Arrays.toString(dataInt));
		sortInt.sortAsc(dataInt);
		System.out.println("����:" + Arrays.toString(dataInt) + "\n");

		dataInt = ArrayGenerator.random(Integer[].class, 10, 0, 99);
		System.out.println("ԭ��:" + Arrays.toString(dataInt));
		sortInt.sortDesc(dataInt);
		System.out.println("����:" + Arrays.toString(dataInt) + "\n");

		ISort<Character> sortChar = new SelectSort<Character>();

		Character[] dataChar = ArrayGenerator.random(Character[].class, 10, 65, 90);
		System.out.println("ԭ��:" + Arrays.toString(dataChar));
		sortChar.sortAsc(dataChar);
		System.out.println("����:" + Arrays.toString(dataChar) + "\n");

		dataChar = ArrayGenerator.random(Character[].class, 10, 65, 90);
		System.out.println("ԭ��:" + Arrays.toString(dataChar));
		sortChar.sortDesc(dataChar);
		System.out.println("����:" + Arrays.toString(dataChar) + "\n");
	}
}
