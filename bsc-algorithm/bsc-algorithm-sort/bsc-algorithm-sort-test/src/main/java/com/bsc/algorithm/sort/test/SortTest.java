package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.bubble.BubbleSort;
import com.bsc.algorithm.sort.heap.HeapSort;
import com.bsc.algorithm.sort.inf.ISort;

public class SortTest {

	public static void main(String[] args) {
		ISort<Integer> sortInt = new HeapSort<Integer>();

		Integer[] dataInt = ArrayGenerator.random(Integer[].class, 20, 0, 99);
		System.out.println("Ô­Ðò:" + Arrays.toString(dataInt));
		sortInt.sortAsc(dataInt, 1, 18);
		System.out.println("ÉýÐò:" + Arrays.toString(dataInt) + "\n");

		dataInt = ArrayGenerator.random(Integer[].class, 20, 0, 99);
		System.out.println("Ô­Ðò:" + Arrays.toString(dataInt));
		sortInt.sortDesc(dataInt, 1, 18);
		System.out.println("½µÐò:" + Arrays.toString(dataInt) + "\n");

		ISort<Character> sortChar = new HeapSort<Character>();

		Character[] dataChar = ArrayGenerator.random(Character[].class, 20, 65, 90);
		System.out.println("Ô­Ðò:" + Arrays.toString(dataChar));
		sortChar.sortAsc(dataChar);
		System.out.println("ÉýÐò:" + Arrays.toString(dataChar) + "\n");

		dataChar = ArrayGenerator.random(Character[].class, 10, 65, 90);
		System.out.println("Ô­Ðò:" + Arrays.toString(dataChar));
		sortChar.sortDesc(dataChar);
		System.out.println("½µÐò:" + Arrays.toString(dataChar) + "\n");
	}
}
