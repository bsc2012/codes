package com.bsc.algorithm.sort.inf;

public interface ISort<T extends Comparable<T>> {

	/**
	 * 升序
	 * 
	 * @param data
	 */
	void sortAsc(T[] data);

	/**
	 * 降序
	 * 
	 * @param data
	 */
	void sortDesc(T[] data);

	/**
	 * 升序
	 * 
	 * @param data
	 */
	void sortAsc(T[] data, int firstIndex, int lastIndex);

	/**
	 * 降序
	 * 
	 * @param data
	 */
	void sortDesc(T[] data, int firstIndex, int lastIndex);

	/**
	 * 比较a,b两个值,a大返回1，b大返回-1，相等返回0
	 * 
	 * @param a
	 * @param b
	 * @return a > b ? 1 : (a < b) ? -1 :0
	 */
	default int compare(T a, T b) {
		int r = a.compareTo(b);
		return r > 0 ? 1 : (r < 0 ? -1 : 0);
		// return a > b ? 1 : (a < b) ? -1 :0;
	}

	/**
	 * 交换数组data第i和第j个元素
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	default void swap(T[] data, int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		// data[i] = data[i] ^ data[j];
		// data[j] = data[i] ^ data[j];
		// data[i] = data[i] ^ data[j];
	}

	default void reverse(T[] data, int from, int to) {
		if (from < to) {
			swap(data, from, to);
			reverse(data, from + 1, to - 1);
		}
	}
}
