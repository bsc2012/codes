package com.bsc.algorithm.sort.merge;

import com.bsc.algorithm.sort.inf.AbstractSort;

public abstract class AbstractMergeSort<T extends Comparable<T>> extends AbstractSort<T>{

	/**
	 * 合并两个有序的数组为一个有序的数组
	 * @param data
	 * @param low
	 * @param middle
	 * @param hight
	 * @param cr
	 * @param tempData
	 */
	protected void merge(T[] data, int low, int middle, int hight, int cr, T[] tempData) {
		int tempDataLength = hight - low + 1;
		int i = low;
		int j = middle + 1;
		int k = 0;
		// 把较小的数先移到临时数组中
		while (i <= middle && j <= hight) {
			if (compare(data[j], data[i]) == cr) {
				tempData[k++] = data[i++];
			} else {
				tempData[k++] = data[j++];
			}
		}
		// 把左边剩余的数移入临时数组
		while (i <= middle) {
			tempData[k++] = data[i++];
		}
		// 把右边边剩余的数移入临时数组
		while (j <= hight) {
			tempData[k++] = data[j++];
		}
		for (int x = 0; x < tempDataLength; x++) {
			data[x + low] = tempData[x];
		}
	}
	
	abstract public void sort(T[] data, int cr, int firstIndex, int lastIndex);
}
