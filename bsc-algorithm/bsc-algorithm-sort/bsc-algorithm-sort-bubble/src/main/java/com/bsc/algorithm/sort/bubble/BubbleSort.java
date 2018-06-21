package com.bsc.algorithm.sort.bubble;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * 冒泡排序
 * 
 * @author bsc
 *
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

	protected void sort(T[] data, int cr) {
		int length = data.length;
		int index;
		do {
			index = 0;
			for (int j = 1; j < length; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
					//记录下交换的位置,至少是1
					index = j;
				}
			}
			//如果到这一步,index=0，证明没有发生过交换，排序结序
			//就算发生交换，只要后面的数交换得少，这样index的值相对于length--也会减少得比较快
			length = index;
		} while (index > 0);
	}

	protected void sort2(T[] data, int cr) {
		int length = data.length;
		boolean isSwap;
		do {
			isSwap = false;
			for (int j = 1; j < length; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
					isSwap = true;
				}
			}
			length--;
		} while (isSwap);
	}

	protected void sort3(T[] data, int cr) {
		int length = data.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 1; j < length - i; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
				}
			}
		}
	}

}
