package com.bsc.algorithm.sort.quick;

import com.bsc.algorithm.sort.inf.AbstractSort;
/**
 * ��������
 * @author bsc
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {

	private void quickSort(T[] data, int low, int hight, int cr) {
		if (low >= hight) {
			return;
		}
		int i = low;
		int j = hight;
		//��׼ֵ
		T benchmark = data[low];
		do {
			// cr == 1(����)ʱ���Ӹ�λ���λ��һ������benchmarkС��
			while (i < j && compare(benchmark, data[j]) != cr) {
				j--;
			}
			// cr == 1ʱ(����),�ӵ�λ���λ��һ������benchmark���
			while (i < j && compare(data[i], benchmark) != cr) {
				i++;
			}
			if (i < j) {
				//�ҵ��󽻻�����,Ȼ�������
				swap(data, i, j);
			}else{
				//�Ҳ����ͽ���
				//��ʱi == j,data[i]����ߵ�������benchmarkС���ұߵ�������benchmark��
				break;
			}
		} while (true);
		data[low] = data[i];
		data[i] = benchmark;
		sort(data, low, i - 1, cr);
		sort(data, i + 1, hight, cr);
	}

	@Override
	public void sort(T[] data, int cr, int firstIndex, int lastIndex) {
		quickSort(data, 0, data.length - 1, cr);
	}

}
