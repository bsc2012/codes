package com.bsc.algorithm.sort.inf;

public abstract class AbstractSort<T extends Comparable<T>> implements ISort<T> {

	@Override
	public void sortAsc(T[] data) {
		sort(data,1);
	}

	@Override
	public void sortDesc(T[] data) {
		sort(data,-1);
	}

	protected abstract void sort(T[] data,int cr);
}
