package com.bsc.algorithm.sort.quick;

import com.bsc.algorithm.sort.inf.AbstractSort;
/**
 * 快速排序
 * @author bsc
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {

	private void quickSort(T[] data, int low, int hight, int cr) {
		if (low >= hight) {
			return;
		}
		int i = low;
		int j = hight;
		//基准值
		T benchmark = data[low];
		do {
			// cr == 1(升序)时，从高位向低位找一个数比benchmark小的
			while (i < j && compare(benchmark, data[j]) != cr) {
				j--;
			}
			// cr == 1时(升序),从低位向高位找一个数比benchmark大的
			while (i < j && compare(data[i], benchmark) != cr) {
				i++;
			}
			if (i < j) {
				//找到后交换两数,然后继续找
				swap(data, i, j);
			}else{
				//找不到就结束
				//此时i == j,data[i]和左边的数都比benchmark小，右边的数都比benchmark大
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
