package com.bsc.algorithm.sort.select;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * —°‘Ò≈≈–Ú
 * @author bsc
 *
 */
public class SelectSort extends AbstractSort {

	@Override
	protected void sort(int[] data, int cr) {
		int length = data.length;

		for (int i = 0; i < length; i++) {
			int value = data[i];
			int index = i;
			for (int j = i + 1; j < length; j++) {
				if (compare(value, data[j]) == cr) {
					value = data[j];
					index = j;
				}
			}
			data[index] = data[i];
			data[i] = value;
		}
	}

}
