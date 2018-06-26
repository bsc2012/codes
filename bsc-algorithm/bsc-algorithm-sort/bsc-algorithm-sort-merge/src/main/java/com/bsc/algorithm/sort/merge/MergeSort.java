package com.bsc.algorithm.sort.merge;

import java.lang.reflect.Array;

import com.bsc.algorithm.sort.inf.AbstractSort;
/**
 * 归并排序
 * @author bsc
 *
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

	private void merge(T[] data, int low, int middle, int hight, int cr, T[] tempData) {
		int tempDataLength = hight - low + 1;
		int i = low;
		int j = middle + 1;
		int k = 0;
		// 把较小的数先移到新数组中
		while (i <= middle && j <= hight) {
			if (compare(data[j], data[i]) == cr) {
				tempData[k++] = data[i++];
			} else {
				tempData[k++] = data[j++];
			}
		}
		// 把左边剩余的数移入数组
		while (i <= middle) {
			tempData[k++] = data[i++];
		}
		// 把右边边剩余的数移入数组
		while (j <= hight) {
			tempData[k++] = data[j++];
		}
		for (int x = 0; x < tempDataLength; x++) {
			data[x + low] = tempData[x];
		}
	}

	private void sort(T[] data, int low, int hight, int cr, T[] tempData) {
		int middle = (low + hight) / 2;
		if (low < hight) {
			sort(data, low, middle, cr, tempData);
			sort(data, middle + 1, hight, cr, tempData);
			merge(data, low, middle, hight, cr, tempData);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void sort(T[] data, int cr) {
		T[] tempData = (T[]) Array.newInstance(data.getClass().getComponentType(), data.length);
		sort(data, 0, data.length - 1, cr, tempData);
	}

}
