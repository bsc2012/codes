package com.bsc.algorithm.sort.shell;

import com.bsc.algorithm.sort.insert.InsertSort;

/**
 * 希尔排序
 * 
 * @author bsc
 *
 */
public class ShellSort<T extends Comparable<T>> extends InsertSort<T> {
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		int length = data.length;
		//初始步长为数组长度的一半
		int increment = length / 2;
		while (increment > 0) {
			//进行插入排序
			sort(data, cr, increment);
			//步长每次减少一半(保证最后一次排序步长为1)
			increment = increment / 2;
		}
	}
}
