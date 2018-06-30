package com.bsc.algorithm.sort.bubble;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * 冒泡排序
 * 
 * @author bsc
 *
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		int length = lastIndex + 1;
		int index;
		do {
			index = 0;
			//一次冒泡过程，index记录的是最大的交换位置，后面的数已经排好序且比前面的数都大
			for (int j = firstIndex + 1; j < length; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
					//记录下交换的位置,至少是1
					index = j;
				}
			}
			//如果index=0,证明没有发生过交换，排序结束
			//如果index>0,证明发生过交换,记录的是最大交换位置
			length = index;
		} while (index > 0);
	}

	public void sort2(T[] data, int cr, int firstIndex, int lastIndex) {
		int length = lastIndex + 1;
		boolean isSwap;
		do {
			isSwap = false;
			//一次冒泡过程，如果没有发生交换，证明已经排好序
			for (int j = firstIndex + 1; j < length; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
					//有交换过
					isSwap = true;
				}
			}
			length--;
			//直到没有交换，排序结束
		} while (isSwap);
	}

	public void sort3(T[] data, int cr, int firstIndex, int lastIndex) {
		int length = lastIndex + 1;
		for (int i = 0; i < length - 1; i++) {
			//一次冒泡过程，把最大值移到第length - i - 1位
			for (int j = firstIndex + 1; j < length - i; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
				}
			}
		}
	}

}
