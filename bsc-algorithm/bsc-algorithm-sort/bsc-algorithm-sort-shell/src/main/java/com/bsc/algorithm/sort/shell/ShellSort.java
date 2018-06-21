package com.bsc.algorithm.sort.shell;

import com.bsc.algorithm.sort.insert.InsertSort;

/**
 * Ï£¶ûÅÅÐò
 * 
 * @author bsc
 *
 */
public class ShellSort<T extends Comparable<T>> extends InsertSort<T> {
	protected void sort(T[] data, int cr) {
		int length = data.length;
		int increment = length / 2;
		while (increment > 0) {
			sort(data, cr, increment);
			increment = increment / 2;
		}
	}

}
