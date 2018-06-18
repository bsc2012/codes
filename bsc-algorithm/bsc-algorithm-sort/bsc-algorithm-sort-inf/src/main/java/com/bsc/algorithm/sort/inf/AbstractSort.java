package com.bsc.algorithm.sort.inf;

public abstract class AbstractSort implements ISort {

	@Override
	public void sortAsc(int[] data) {
		sort(data,1);
	}

	@Override
	public void sortDesc(int[] data) {
		sort(data,-1);
	}

	protected abstract void sort(int[] data,int cr);
}
