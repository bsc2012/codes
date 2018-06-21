package com.bsc.algorithm.sort.test;

import java.util.Arrays;

import com.bsc.algorithm.data.generator.ArrayGenerator;
import com.bsc.algorithm.sort.inf.ISort;
import com.bsc.algorithm.sort.shell.ShellSort;

public class Test {

	public static void main(String[] args) {
		int[] array = ArrayGenerator.randomInt(26, 0, 25);
		Character[] data = new Character[array.length];
		for(int i = 0;i < array.length;i++){
			data[i] = (char)('a' + array[i]);
		}
		
		ISort<Character> sort = new ShellSort<Character>();
		System.out.println("Ô­Ðò:" + Arrays.toString(data));
		sort.sortAsc(data);
		System.out.println("ÉýÐò:" + Arrays.toString(data));
		sort.sortDesc(data);
		System.out.println("½µÐò:" + Arrays.toString(data));
		
		
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
