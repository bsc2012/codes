package com.bsc.algorithm.sort.shell;

import com.bsc.algorithm.sort.insert.InsertSort;

/**
 * ϣ������
 * 
 * @author bsc
 *
 */
public class ShellSort<T extends Comparable<T>> extends InsertSort<T> {
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		int length = data.length;
		//��ʼ����Ϊ���鳤�ȵ�һ��
		int increment = length / 2;
		while (increment > 0) {
			//���в�������
			sort(data, cr, increment);
			//����ÿ�μ���һ��(��֤���һ�����򲽳�Ϊ1)
			increment = increment / 2;
		}
	}
}
