package com.bsc.algorithm.sort.select;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * ѡ������
 * @author bsc
 *
 */
public class SelectSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	/**
	 * �ҳ���1�������һ��Ԫ������Сֵ�����1������
	 * �ҳ���2�������һ��Ԫ������Сֵ�����2������
	 * ...
	 * �ҳ�������2�������һ��Ԫ������Сֵ���뵹����2������
	 */
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		int length = lastIndex + 1;

		for (int i = firstIndex; i < length - 1; i++) {
			//��Сֵ
			T minValue = data[i];
			//��Сֵ��������
			int minValueIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (compare(minValue, data[j]) == cr) {
					//��¼���ֵ����Сֵ
					minValue = data[j];
					//��¼��Сֵ��������
					minValueIndex = j;
				}
			}
			if(minValueIndex > i){
				//����Сֵ�͵�i��Ԫ�ؽ���
				data[minValueIndex] = data[i];
				data[i] = minValue;
			}
		}
	}
}
