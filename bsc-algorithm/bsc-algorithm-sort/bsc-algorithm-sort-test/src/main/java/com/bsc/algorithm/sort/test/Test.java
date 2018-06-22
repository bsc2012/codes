package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.inf.ISort;
import com.bsc.algorithm.sort.quick.QuickSort;

public class Test<T extends Comparable<T>> {
	
	public boolean isAsc(T[] data){
		for(int i = 0;i < data.length - 1;i++){
			if(data[i].compareTo(data[i + 1]) > 0){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Test<Integer> test = new Test<>();
		int[] array = ArrayGenerator.randomInt(10, 0, 99);
		Integer[] data = new Integer[array.length];
		for(int i = 0;i < array.length;i++){
			//data[i] = (char)('a' + array[i]);
			data[i] = array[i];
		}
		
		ISort<Integer> sort = new QuickSort<Integer>();
		System.out.println("Ô­Ðò:" + Arrays.toString(data));
		sort.sortAsc(data);
		System.out.println("ÉýÐò:" + test.isAsc(data) + ":" + Arrays.toString(data));
		sort.sortDesc(data);
		System.out.println("½µÐò:" + Arrays.toString(data));
	}
}
