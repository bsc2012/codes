package com.bsc.algorithm.sort.merge;

import com.bsc.algorithm.sort.inf.AbstractSort;

public abstract class AbstractMergeSort<T extends Comparable<T>> extends AbstractSort<T>{

	/**
	 * �ϲ��������������Ϊһ�����������
	 * @param data
	 * @param low
	 * @param middle
	 * @param hight
	 * @param cr
	 * @param tempData
	 */
	protected void merge(T[] data, int low, int middle, int hight, int cr, T[] tempData) {
		int tempDataLength = hight - low + 1;
		int i = low;
		int j = middle + 1;
		int k = 0;
		// �ѽ�С�������Ƶ���ʱ������
		while (i <= middle && j <= hight) {
			if (compare(data[j], data[i]) == cr) {
				tempData[k++] = data[i++];
			} else {
				tempData[k++] = data[j++];
			}
		}
		// �����ʣ�����������ʱ����
		while (i <= middle) {
			tempData[k++] = data[i++];
		}
		// ���ұ߱�ʣ�����������ʱ����
		while (j <= hight) {
			tempData[k++] = data[j++];
		}
		for (int x = 0; x < tempDataLength; x++) {
			data[x + low] = tempData[x];
		}
	}
	
	abstract public void sort(T[] data, int cr, int firstIndex, int lastIndex);
}
