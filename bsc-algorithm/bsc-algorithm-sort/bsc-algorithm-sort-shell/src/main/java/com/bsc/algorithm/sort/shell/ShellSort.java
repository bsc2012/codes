package com.bsc.algorithm.sort.shell;

import com.bsc.algorithm.sort.insert.InsertSort;

/**
 * ϣ������
 * 
 * @author bsc
 *
 */
public class ShellSort extends InsertSort {
	protected void sort(int[] data, int cr) {
		int length = data.length;
		int increment = length / 2;
		while (increment > 0) {
			sort(data, cr, increment);
			increment = increment / 2;
		}
	}

}
