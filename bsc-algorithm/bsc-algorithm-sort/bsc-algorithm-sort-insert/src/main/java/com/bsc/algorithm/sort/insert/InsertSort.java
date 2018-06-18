package com.bsc.algorithm.sort.insert;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * ��������
 * 
 * @author bsc
 *
 */
public class InsertSort extends AbstractSort {
	/**
	 * 
	 * @param data
	 *            Ҫ���������
	 * @param cr
	 *            1��������,-1������
	 */
	protected void sort(int[] data, int cr) {
		sort(data, cr, 1);
	}

	protected void sort(int[] data,int cr, int increment) {
		int length = data.length;
		// �ӵ�increment������ʼ����ǰ�����(���Ϊincrement)�Ƚ�(ǰ�����(���Ϊincrement)�Ѿ��ź���)
		for (int i = increment; i < length; i += increment) {
			int insertNum = data[i];			
			int j = i - increment;
			// ǰ�����źõ����뵱ǰinsertNum�Ƚϣ�����ϴ�(����),��С(����),��j��������ǰ��incrementλ
			while (j >= 0 && compare(data[j],insertNum) == cr) {
				// ǰ��������Ǻ����������ʾ��ǰ��һλ
				data[j + increment] = data[j];	
				j -= increment;
			}
			data[j + increment] = insertNum;
		}
	}

}
