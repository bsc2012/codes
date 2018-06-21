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
	 * 找出第0到第data.length - 1个元素中最大或最小，和第0个元素交换
	 * 找出第1到第data.length - 1个元素中最大或最小，和第1个元素交换
	 * ...
	 * 找出第data.length - 2到第data.length - 1个元素中最大或最小，和第data.length - 2个元素交换
	 */
	protected void sort(T[] data, int cr) {
		int length = data.length;

		for (int i = 0; i < length - 1; i++) {
			//最大或最小值
			T maxOrMinValue = data[i];
			//最大或最小值数组座标
			int maxOrMinValueIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (compare(maxOrMinValue, data[j]) == cr) {
					//记录最大值或最小值
					maxOrMinValue = data[j];
					//记录最大值或最小值数组座标
					maxOrMinValueIndex = j;
				}
			}
			if(maxOrMinValueIndex > i){
				//把最大值或最小值和第i个元素交换
				data[maxOrMinValueIndex] = data[i];
				data[i] = maxOrMinValue;
			}
		}
	}

}
