package com.bsc.algorithm.sort.heap;

import com.bsc.algorithm.sort.inf.AbstractSort;
/**
 * 堆排序
 * @author bsc
 * 
 * 一个长度为n的数组，将它看成一个完全二叉树的顺序存储结构
 * 当n >= 2时，第i个元素代表非叶子结点，至少有一个孩子,i满足 0 <= i <= (n-2)/2
 * 第i个元素的左孩子是:2i + 1(一定存在),右孩子是:2i + 2(当i=(n-2)/2时可能不存在)
 */
public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {

	/**
	 * 把父结点parent以下的子结点中的最大值移到父结点上(parent以下的所有非叶子子结点要大于自己的孩子)
	 * 父结点原值找到子结点合适位置替换
	 * @param data
	 * @param parentIndex
	 * @param length
	 * @param cr
	 */
	private void heapAdjust(T[] data, int parentIndex, int length, int cr) {
		T parent = data[parentIndex];
		int childIndex = 2 * parentIndex + 1; // 先获得左孩子

		while (childIndex < length) {
			// 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
			/* data[childIndex] < data[childIndex + 1] */
			if (childIndex + 1 < length
					 && compare(data[childIndex + 1], data[childIndex]) == cr) {
				childIndex++;
			}
			// 如果父结点的值已经大于孩子结点的值，则直接结束
			/* parent >= data[childIndex] */
			if (compare(data[childIndex], parent) != cr){
				break;
			}
			// 如果孩子结点大于父结点,把孩子结点的值赋给父结点
			data[parentIndex] = data[childIndex];
			// 选取孩子结点的左孩子结点,继续向下筛选
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		data[parentIndex] = parent;
	}

	@Override
	protected void sort(T[] data, int firstIndex, int lastIndex, int cr) {
		int length = data.length;
		// 循环建立初始堆
		// (data.length - 2) / 2 : 最大非叶子结点位置
		for (int i = (length - 2) / 2; i >= 0; i--) {
			heapAdjust(data, i, length, cr);
		}
		// 进行n-1次循环，完成排序
		for (int i = length - 1; i > 0; i--) {
			// 交换堆顶的元素和最后一个元素，此时最后一个位置作为有序区
			swap(data, 0, i);
			// 然后进行其他无序区的堆调整，重新得到大顶堆后
			heapAdjust(data, 0, i, cr);
		}
	}

}
