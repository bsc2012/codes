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
	 * �ҳ���0����data.length - 1��Ԫ������Сֵ���͵�0��Ԫ�ؽ���
	 * �ҳ���1����data.length - 1��Ԫ������Сֵ���͵�1��Ԫ�ؽ���
	 * ...
	 * �ҳ���data.length - 2����data.length - 1��Ԫ������Сֵ���͵�data.length - 2��Ԫ�ؽ���
	 */
	protected void sort(T[] data, int cr) {
		int length = data.length;

		for (int i = 0; i < length - 1; i++) {
			//��Сֵ
			T minValue = data[i];
			//������Сֵ��������
			int minValueIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (compare(minValue, data[j]) == cr) {
					//��¼���ֵ����Сֵ
					minValue = data[j];
					//��¼���ֵ����Сֵ��������
					minValueIndex = j;
				}
			}
			if(minValueIndex > i){
				//�����ֵ����Сֵ�͵�i��Ԫ�ؽ���
				data[minValueIndex] = data[i];
				data[i] = minValue;
			}
		}
	}
}
