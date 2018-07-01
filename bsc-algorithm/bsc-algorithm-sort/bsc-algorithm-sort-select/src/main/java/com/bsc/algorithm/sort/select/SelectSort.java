package com.bsc.algorithm.sort.select;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * 选择排序
 * @author bsc
 *
 */
public class SelectSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	/**
	 * 找出第1个到最后一个元素中最小值，与第1个交换
	 * 找出第2个到最后一个元素中最小值，与第2个交换
	 * ...
	 * 找出倒数第2个与最后一个元素中最小值，与倒数第2个交换
	 */
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		int length = lastIndex + 1;

		for (int i = firstIndex; i < length - 1; i++) {
			//最小值
			T minValue = data[i];
			//最小值数组座标
			int minValueIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (compare(minValue, data[j]) == cr) {
					//记录最大值或最小值
					minValue = data[j];
					//记录最小值数组座标
					minValueIndex = j;
				}
			}
			if(minValueIndex > i){
				//把最小值和第i个元素交换
				data[minValueIndex] = data[i];
				data[i] = minValue;
			}
		}
	}
}
