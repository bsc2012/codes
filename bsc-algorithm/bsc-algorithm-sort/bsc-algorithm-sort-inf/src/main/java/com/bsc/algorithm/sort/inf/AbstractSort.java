package com.bsc.algorithm.sort.inf;

public abstract class AbstractSort<T extends Comparable<T>> implements ISort<T> {

	@Override
	public void sortAsc(T[] data) {
		sort(data, 1);
	}

	@Override
	public void sortDesc(T[] data) {
		sort(data, -1);
	}

	private void sort(T[] data, int cr) {
		sort(data, 0, data.length - 1, cr);
	}

	protected abstract void sort(T[] data, int firstIndex, int lastIndex, int cr);
}
