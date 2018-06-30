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
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
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
		// �ӵ�increment������ʼ������ߵ���(���Ϊincrement)�Ƚ�(��ߵ���(���Ϊincrement)�Ѿ��ź���)
		for (int i = increment; i < length; i += increment) {
			T current = data[i];			
			int j = i - increment;
			// ������źõ����뵱ǰcurrent�Ƚϣ�����ϴ�(����),��С(����),��j������������incrementλ
			while (j >= 0 && compare(data[j],current) == cr) {
				// ��ߵ��������ұߵ�������ʾ������incrementλ
				data[j + increment] = data[j];	
				j -= increment;
			}
			//�����嵽��ȷλ��
			data[j + increment] = current;
		}
	}
}
