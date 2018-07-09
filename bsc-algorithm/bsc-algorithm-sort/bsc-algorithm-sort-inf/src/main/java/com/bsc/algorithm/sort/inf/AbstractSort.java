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
	
	@Override
	public void sortAsc(T[] data, int firstIndex, int lastIndex) {
		sort(data, 1, firstIndex, lastIndex);
	}

	@Override
	public void sortDesc(T[] data, int firstIndex, int lastIndex) {
		sort(data, -1, firstIndex, lastIndex);
	}

	private void sort(T[] data, int cr) {
		sort(data, cr, 0, data.length - 1);
	}

	protected abstract void sort(T[] data, int cr, int firstIndex, int lastIndex);
}
