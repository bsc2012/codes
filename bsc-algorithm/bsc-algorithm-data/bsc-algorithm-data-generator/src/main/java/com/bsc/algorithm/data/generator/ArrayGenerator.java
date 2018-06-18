package com.bsc.algorithm.data.generator;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

	public static int[] randomInt(int size, int min, int max) {
		int diff = max - min + 1;
		Random random = new Random();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(diff) + min;
		}
		return array;
	}

	public static int[] seqInt(int size, int start, int step) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = start;
			start += step;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = ArrayGenerator.seqInt(100, 0, 1);
		System.out.println(Arrays.toString(array));
	}
}
