package com.bsc.algorithm.sort.insert;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * 插入排序
 * 
 * @author bsc
 *
 */
public class InsertSort<T extends Comparable<T>> extends AbstractSort<T> {
	/**
	 * 
	 * @param data
	 *            要排序的数组
	 * @param cr
	 *            1代表升序,-1代表降序
	 */
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		sort(data, cr, 1);
	}

	/**
	 * 
	 * @param data 要排序的数组
	 * @param cr 1代表升序,-1代表降序
	 * @param increment 步长
	 */
	protected void sort(T[] data,int cr, int increment) {
		int length = data.length;
		// 从第increment个数开始，和左边的数(间隔为increment)比较(左边的数(间隔为increment)已经排好序)
		for (int i = increment; i < length; i += increment) {
			T current = data[i];			
			int j = i - increment;
			// 左边已排好的数与当前current比较，如果较大(升序),较小(降序),第j个数就向左移increment位
			while (j >= 0 && compare(data[j],current) == cr) {
				// 左边的数覆盖右边的数，表示向右移increment位
				data[j + increment] = data[j];	
				j -= increment;
			}
			//把数插到正确位置
			data[j + increment] = current;
		}
	}
}
