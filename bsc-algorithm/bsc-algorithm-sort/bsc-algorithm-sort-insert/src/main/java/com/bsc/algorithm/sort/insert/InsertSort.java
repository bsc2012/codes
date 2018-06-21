package com.bsc.algorithm.sort.insert;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * ��������
 * 
 * @author bsc
 *
 */
public class InsertSort<T extends Comparable<T>> extends AbstractSort<T> {
	/**
	 * 
	 * @param data
	 *            Ҫ���������
	 * @param cr
	 *            1��������,-1������
	 */
	protected void sort(T[] data, int cr) {
		sort(data, cr, 1);
	}

	/**
	 * 
	 * @param data Ҫ���������
	 * @param cr 1��������,-1������
	 * @param increment ����
	 */
	protected void sort(T[] data,int cr, int increment) {
		int length = data.length;
		// �ӵ�increment������ʼ����ǰ�����(���Ϊincrement)�Ƚ�(ǰ�����(���Ϊincrement)�Ѿ��ź���)
		for (int i = increment; i < length; i += increment) {
			T current = data[i];			
			int j = i - increment;
			// ǰ�����źõ����뵱ǰinsertNum�Ƚϣ�����ϴ�(����),��С(����),��j��������ǰ��incrementλ
			while (j >= 0 && compare(data[j],current) == cr) {
				// ǰ��������Ǻ����������ʾ��ǰ��һλ
				data[j + increment] = data[j];	
				j -= increment;
			}
			data[j + increment] = current;
		}
	}

}
