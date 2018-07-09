package com.bsc.algorithm.sort.merge;

import java.lang.reflect.Array;

/**
 * 归并排序
 * @author bsc
 * 1、将数组分成A,B两段，如果A无序，进行第2步，如果B无序，进行第2步，将A替换成B，如果A和B分别都有序，将它们合并,排序完成
 * 2、将A分成C,D两段，如果C无序，再进行这一步操作，将A替换成C，如果D无序，再进行这一步操作，将A替换成D，如果C,D分别都有序，将它们合并
 * 3、如果一段数组无序，那证明它至少有两个元素，可以再进行拆分，直到只有一个元素，这时代表这一段数组是有序的
 */
public class MergeSort<T extends Comparable<T>> extends AbstractMergeSort<T> {
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
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		//排序开始时就创建一个临时数组，避免在合并有序数组过程中不断创建新的数组
		T[] tempData = (T[]) Array.newInstance(data.getClass().getComponentType(), lastIndex - firstIndex + 1);
		sort(data, firstIndex, lastIndex, cr, tempData);
	}

}
