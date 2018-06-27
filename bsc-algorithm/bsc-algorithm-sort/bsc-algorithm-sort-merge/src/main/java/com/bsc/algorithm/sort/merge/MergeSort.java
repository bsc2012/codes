package com.bsc.algorithm.sort.merge;

import java.lang.reflect.Array;

import com.bsc.algorithm.sort.inf.AbstractSort;
/**
 * �鲢����
 * @author bsc
 * 1��������ֳ�A,B���Σ����A���򣬽��е�2�������B���򣬽��е�2������A�滻��B�����A��B�ֱ����򣬽����Ǻϲ�,�������
 * 2����A�ֳ�C,D���Σ����C�����ٽ�����һ����������A�滻��C�����D�����ٽ�����һ����������A�滻��D�����C,D�ֱ����򣬽����Ǻϲ�
 * 3�����һ������������֤��������������Ԫ�أ������ٽ��в�֣�ֱ��ֻ��һ��Ԫ�أ���ʱ������һ�������������
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

	/**
	 * �ϲ��������������Ϊһ�����������
	 * @param data
	 * @param low
	 * @param middle
	 * @param hight
	 * @param cr
	 * @param tempData
	 */
	private void merge(T[] data, int low, int middle, int hight, int cr, T[] tempData) {
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

	/**
	 * ��data�����lowλ����hightλ����������
	 * ��ǰ�벿�ݺͺ�벿�ݷֱ���������ٽ��кϲ�
	 * @param data
	 * @param low
	 * @param hight
	 * @param cr
	 * @param tempData
	 */
	private void sort(T[] data, int low, int hight, int cr, T[] tempData) {
		int middle = (low + hight) / 2;
		if (low < hight) {
			sort(data, low, middle, cr, tempData);
			sort(data, middle + 1, hight, cr, tempData);
			merge(data, low, middle, hight, cr, tempData);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void sort(T[] data, int cr) {
		//����ʼʱ�ʹ���һ����ʱ���飬�����ںϲ�������������в��ϴ����µ�����
		T[] tempData = (T[]) Array.newInstance(data.getClass().getComponentType(), data.length);
		sort(data, 0, data.length - 1, cr, tempData);
	}

}
