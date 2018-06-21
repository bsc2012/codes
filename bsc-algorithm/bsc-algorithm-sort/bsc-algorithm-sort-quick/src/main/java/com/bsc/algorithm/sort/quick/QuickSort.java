package com.bsc.algorithm.sort.quick;

import com.bsc.algorithm.sort.inf.AbstractSort;

public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {

	private void sort(T[] data, int low, int hight, int cr) {
		if (low >= hight) {
			return;
		}
		int i = low;
		int j = hight;
		T benchmark = data[low];
		do {
			// cr == 1时(升序),benchmark <= data[j],直到找到一个 benchmark > data[j]
			// cr == -1时(降序),benchmark >= data[j]
			while (i < j && compare(benchmark, data[j]) != cr) {
				j--;
			}
			// cr == 1时(升序),data[i] <= benchmark
			// cr == -1时(降序),data[i] >= benchmark
			while (i < j && compare(data[i], benchmark) != cr) {
				i++;
			}
			if (i < j) {
				swap(data, i, j);
			}
		} while (i < j);
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
