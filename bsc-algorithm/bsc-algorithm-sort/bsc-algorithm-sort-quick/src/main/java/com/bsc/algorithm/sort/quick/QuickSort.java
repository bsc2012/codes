package com.bsc.algorithm.sort.quick;

import com.bsc.algorithm.sort.inf.AbstractSort;

public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {

	private void sort(T[] data, int low, int hight, int cr) {
		if (low >= hight) {
			return;
		}
		int i = low;
		int j = hight;
		//基准值
		T benchmark = data[low];
		do {
			// cr == 1时(升序),data[j] >= benchmark,直到找到一个data[j] < benchmark
			while (i < j && compare(benchmark, data[j]) != cr) {
				j--;
			}
			// cr == 1时(升序),data[i] <= benchmark,直到找到一个 data[i] > benchmark
			while (i < j && compare(data[i], benchmark) != cr) {
				i++;
			}
			if (i < j) {
				swap(data, i, j);
			}else{
				break;
			}
		} while (true);
		data[low] = data[i];
		data[i] = benchmark;
		sort(data, low, i - 1, cr);
		sort(data, i + 1, hight, cr);
	}

	@Override
	protected void sort(T[] data, int cr) {
		sort(data, 0, data.length - 1, cr);
	}

}
