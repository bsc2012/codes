package com.bsc.algorithm.sort.bubble;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * ð������
 * 
 * @author bsc
 *
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

	protected void sort(T[] data, int cr) {
		int length = data.length;
		int index;
		do {
			index = 0;
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

	protected void sort2(T[] data, int cr) {
		int length = data.length;
		boolean isSwap;
		do {
			isSwap = false;
			for (int j = 1; j < length; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
					isSwap = true;
				}
			}
			length--;
		} while (isSwap);
	}

	protected void sort3(T[] data, int cr) {
		int length = data.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 1; j < length - i; j++) {
				if (compare(data[j - 1], data[j]) == cr) {
					swap(data, j - 1, j);
				}
			}
		}
	}

}
