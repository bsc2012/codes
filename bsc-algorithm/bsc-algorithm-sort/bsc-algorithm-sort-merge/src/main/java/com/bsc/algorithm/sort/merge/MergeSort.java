package com.bsc.algorithm.sort.merge;

import java.lang.reflect.Array;

import com.bsc.algorithm.sort.inf.AbstractSort;
/**
 * 归并排序
 * @author bsc
 * 1、将数组分成A,B两段，如果A无序，进行第2步，如果B无序，进行第2步，将A替换成B，如果A和B分别都有序，将它们合并,排序完成
 * 2、将A分成C,D两段，如果C无序，再进行这一步操作，将A替换成C，如果D无序，再进行这一步操作，将A替换成D，如果C,D分别都有序，将它们合并
 * 3、如果一段数组无序，那证明它至少有两个元素，可以再进行拆分，直到只有一个元素，这时代表这一段数组是有序的
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

	/**
	 * 合并两个有序的数组为一个有序的数组
	 * @param data
	 * @param low
	 * @param middle
	 * @param hight
	 * @param cr
	 * @param tempData
	 */
	private void merge(T[] data, int low, int middle, int hight, int cr, T[] tempData) {
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

	/**
	 * 对data数组第low位到第hight位数进行排序
	 * 将前半部份和后半部份分别进行排序，再进行合并
	 * @param data
	 * @param low
	 * @param hight
	 * @param cr
	 * @param tempData
	 */
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
		//排序开始时就创建一个临时数组，避免在合并有序数组过程中不断创建新的数组
		T[] tempData = (T[]) Array.newInstance(data.getClass().getComponentType(), data.length);
		sort(data, 0, data.length - 1, cr, tempData);
	}

}
