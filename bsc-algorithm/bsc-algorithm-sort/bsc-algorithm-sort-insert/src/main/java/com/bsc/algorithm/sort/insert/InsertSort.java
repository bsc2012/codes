package com.bsc.algorithm.sort.insert;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * 插入排序
 * 
 * @author bsc
 *
 */
public class InsertSort extends AbstractSort {
	/**
	 * 
	 * @param data
	 *            要排序的数组
	 * @param cr
	 *            1代表升序,-1代表降序
	 */
	protected void sort(int[] data, int cr) {
		sort(data, cr, 1);
	}

	protected void sort(int[] data,int cr, int increment) {
		int length = data.length;
		// 从第increment个数开始，和前面的数(间隔为increment)比较(前面的数(间隔为increment)已经排好序)
		for (int i = increment; i < length; i += increment) {
			int insertNum = data[i];			
			int j = i - increment;
			// 前面已排好的数与当前insertNum比较，如果较大(升序),较小(降序),第j个数就向前移increment位
			while (j >= 0 && compare(data[j],insertNum) == cr) {
				// 前面的数覆盖后面的数，表示向前移一位
				data[j + increment] = data[j];	
				j -= increment;
			}
			data[j + increment] = insertNum;
		}
	}

}
