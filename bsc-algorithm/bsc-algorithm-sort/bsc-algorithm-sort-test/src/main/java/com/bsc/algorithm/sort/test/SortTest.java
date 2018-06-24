package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.inf.ISort;
import com.bsc.algorithm.sort.quick.QuickSort;

public class SortTest {

	public static void main(String[] args) {
		ISort<Integer> sortInt = new QuickSort<Integer>();

		Integer[] dataInt = ArrayGenerator.random(Integer[].class, 10, 0, 99);
		System.out.println("Ô­Ðò:" + Arrays.toString(dataInt));
		sortInt.sortAsc(dataInt);
		System.out.println("ÉýÐò:" + Arrays.toString(dataInt) + "\n");

		dataInt = ArrayGenerator.random(Integer[].class, 10, 0, 99);
		System.out.println("Ô­Ðò:" + Arrays.toString(dataInt));
		sortInt.sortDesc(dataInt);
		System.out.println("½µÐò:" + Arrays.toString(dataInt) + "\n");

		ISort<Character> sortChar = new QuickSort<Character>();

		Character[] dataChar = ArrayGenerator.random(Character[].class, 10, 65, 90);
		System.out.println("Ô­Ðò:" + Arrays.toString(dataChar));
		sortChar.sortAsc(dataChar);
		System.out.println("ÉýÐò:" + Arrays.toString(dataChar) + "\n");

		dataChar = ArrayGenerator.random(Character[].class, 10, 65, 90);
		System.out.println("Ô­Ðò:" + Arrays.toString(dataChar));
		sortChar.sortDesc(dataChar);
		System.out.println("½µÐò:" + Arrays.toString(dataChar) + "\n");
	}
}
