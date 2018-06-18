package com.bsc.algorithm.sort.inf;

public interface ISort {

	void sortAsc(int[] data);
	
	void sortDesc(int[] data);
	
	/**
	 * @param a
	 * @param b
	 * @return a > b ? 1 : (a < b) ? -1 :0
	 */
	default int compare(int a, int b) {
		return a > b ? 1 : (a < b) ? -1 :0;
	}
	
	default void swap(int[] data,int i,int j) {
		data[i] = data[i]^data[j];
		data[j] = data[i]^data[j];
		data[i] = data[i]^data[j];
	}
}
