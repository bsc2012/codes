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
	 * �ҳ���0����data.length - 1��Ԫ����������С���͵�0��Ԫ�ؽ���
	 * �ҳ���1����data.length - 1��Ԫ����������С���͵�1��Ԫ�ؽ���
	 * ...
	 * �ҳ���data.length - 2����data.length - 1��Ԫ����������С���͵�data.length - 2��Ԫ�ؽ���
	 */
	protected void sort(T[] data, int cr) {
		int length = data.length;

		for (int i = 0; i < length - 1; i++) {
			//������Сֵ
			T maxOrMinValue = data[i];
			//������Сֵ��������
			int maxOrMinValueIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (compare(maxOrMinValue, data[j]) == cr) {
					//��¼���ֵ����Сֵ
					maxOrMinValue = data[j];
					//��¼���ֵ����Сֵ��������
					maxOrMinValueIndex = j;
				}
			}
			if(maxOrMinValueIndex > i){
				//�����ֵ����Сֵ�͵�i��Ԫ�ؽ���
				data[maxOrMinValueIndex] = data[i];
				data[i] = maxOrMinValue;
			}
		}
	}

}
