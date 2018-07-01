package com.bsc.algorithm.sort.heap;

import com.bsc.algorithm.sort.inf.AbstractSort;

/**
 * ������
 * 
 * @author bsc
 * 
 *         һ������Ϊn�����飬��������һ����ȫ��������˳��洢�ṹ ��n >= 2ʱ����i��Ԫ�ش����Ҷ�ӽ�㣬������һ������,i���� 0 <= i
 *         <= (n-2)/2 ��i��Ԫ�ص�������:2i + 1(һ������),�Һ�����:2i + 2(��i=(n-2)/2ʱ���ܲ�����)
 */
public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {

	/**
	 * �Ѹ����parent���µ��ӽ���е����ֵ�Ƶ��������(parent���µ����з�Ҷ���ӽ��Ҫ�����Լ��ĺ���) �����ԭֵ�ҵ��ӽ�����λ���滻
	 * 
	 * @param data
	 * @param parentIndex
	 * @param length
	 * @param cr
	 */
	private void heapAdjust(T[] data, int parentIndex, int length, int cr, int firstIndex) {
		T parent = data[parentIndex];
		//int childIndex = 2 * (parentIndex - firstIndex) + 1 + firstIndex; // �Ȼ������
		int childIndex = 2 * parentIndex - firstIndex + 1; 
		while (childIndex < length) {
			// ������Һ��ӽ�㣬�����Һ��ӽ���ֵ�������ӽ�㣬��ѡȡ�Һ��ӽ��
			/* data[childIndex] < data[childIndex + 1] */
			if (childIndex + 1 < length && compare(data[childIndex + 1], data[childIndex]) == cr) {
				childIndex++;
			}
			// ���������ֵ�Ѿ����ں��ӽ���ֵ����ֱ�ӽ���
			/* parent >= data[childIndex] */
			if (compare(data[childIndex], parent) != cr) {
				break;
			}
			// ������ӽ����ڸ����,�Ѻ��ӽ���ֵ���������
			data[parentIndex] = data[childIndex];
			// ѡȡ���ӽ������ӽ��,��������ɸѡ
			parentIndex = childIndex;
			//childIndex = 2 * (childIndex - firstIndex) + 1 + firstIndex;
			childIndex = 2 * childIndex - firstIndex + 1;
		}
		data[parentIndex] = parent;
	}

	@Override
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		int length = lastIndex + 1;
		// ѭ��������ʼ��
		// (data.length - 2) / 2 : ����Ҷ�ӽ��λ��
		for (int i = (lastIndex - firstIndex - 1) / 2 + firstIndex; i >= firstIndex; i--) {
			heapAdjust(data, i, length, cr, firstIndex);
		}
		// ����n-1��ѭ�����������
		for (int i = lastIndex; i > firstIndex; i--) {
			// �����Ѷ���Ԫ�غ����һ��Ԫ�أ���ʱ���һ��λ����Ϊ������
			swap(data, firstIndex, i);
			// Ȼ����������������Ķѵ��������µõ��󶥶Ѻ�
			heapAdjust(data, firstIndex, i, cr, firstIndex);
		}
	}

}
