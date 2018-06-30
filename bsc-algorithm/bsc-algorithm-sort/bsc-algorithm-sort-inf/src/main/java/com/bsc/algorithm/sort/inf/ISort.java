package com.bsc.algorithm.sort.inf;

public interface ISort<T extends Comparable<T>> {

	/**
	 * ����
	 * @param data
	 */
	void sortAsc(T[] data);

	/**
	 * ����
	 * @param data
	 */
	void sortDesc(T[] data);
	
	/**
	 * ����
	 * @param data
	 */
	void sortAsc(T[] data, int firstIndex, int lastIndex);

	/**
	 * ����
	 * @param data
	 */
	void sortDesc(T[] data, int firstIndex, int lastIndex);

	/**
	 * �Ƚ�a,b����ֵ,a�󷵻�1��b�󷵻�-1����ȷ���0
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
	 * ��������data��i�͵�j��Ԫ��
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	default void swap(T[] data, int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
//		data[i] = data[i] ^ data[j];
//		data[j] = data[i] ^ data[j];
//		data[i] = data[i] ^ data[j];
	}
}
