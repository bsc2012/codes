package com.bsc.algorithm.data.tree;

public interface INodeHandler<T extends Comparable<T>> {

	void handler(Node<T> node);
}
