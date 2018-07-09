package com.bsc.algorithm.sort.merge;

import java.lang.reflect.Array;

/**
 * �鲢����
 * @author bsc
 * 1��������ֳ�A,B���Σ����A���򣬽��е�2�������B���򣬽��е�2������A�滻��B�����A��B�ֱ����򣬽����Ǻϲ�,�������
 * 2����A�ֳ�C,D���Σ����C�����ٽ�����һ����������A�滻��C�����D�����ٽ�����һ����������A�滻��D�����C,D�ֱ����򣬽����Ǻϲ�
 * 3�����һ������������֤��������������Ԫ�أ������ٽ��в�֣�ֱ��ֻ��һ��Ԫ�أ���ʱ������һ�������������
 */
public class MergeSort<T extends Comparable<T>> extends AbstractMergeSort<T> {
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
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		//����ʼʱ�ʹ���һ����ʱ���飬�����ںϲ�������������в��ϴ����µ�����
		T[] tempData = (T[]) Array.newInstance(data.getClass().getComponentType(), lastIndex - firstIndex + 1);
		sort(data, firstIndex, lastIndex, cr, tempData);
	}

}
