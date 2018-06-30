package com.bsc.algorithm.sort.bubble;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * ð������
 * 
 * @author bsc
 *
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

	protected void sort(T[] data, int firstIndex, int lastIndex, int cr) {
		int length = data.length;
		int index;
		do {
			index = 0;
			//һ��ð�ݹ��̣�index��¼�������Ľ���λ�ã���������Ѿ��ź����ұ�ǰ���������
			for (int j = 1; j < length; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
					//��¼�½�����λ��,������1
					index = j;
				}
			}
			//���index=0,֤��û�з������������������
			//���index>0,֤������������,��¼������󽻻�λ��
			length = index;
		} while (index > 0);
	}

	protected void sort2(T[] data, int firstIndex, int lastIndex, int cr) {
		int length = data.length;
		boolean isSwap;
		do {
			isSwap = false;
			//һ��ð�ݹ��̣����û�з���������֤���Ѿ��ź���
			for (int j = 1; j < length; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
					//�н�����
					isSwap = true;
				}
			}
			length--;
			//ֱ��û�н������������
		} while (isSwap);
	}

	protected void sort3(T[] data, int firstIndex, int lastIndex, int cr) {
		int length = data.length;
		for (int i = 0; i < length - 1; i++) {
			//һ��ð�ݹ��̣������ֵ�Ƶ���length - i - 1λ
			for (int j = 1; j < length - i; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
				}
			}
		}
	}

}
