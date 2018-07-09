package com.bsc.algorithm.data.tree;

import java.util.Stack;

public class BinaryTree{

	/**
	 * 递归前序遍历(中左右)
	 * @param <T>
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static <T extends Comparable<T>> void preOrderTraversal(Node<T> node, INodeHandler<T> nodeHandler) {
		if (node == null) {
			return;
		}
		nodeHandler.handler(node);
		preOrderTraversal(node.getLeftNode(), nodeHandler);
		preOrderTraversal(node.getRightNode(), nodeHandler);
	}

	/**
	 * 非递归前序遍历(中左右)
	 * @param <T>
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static <T extends Comparable<T>> void preOrderTraversalByLoop(Node<T> node, INodeHandler<T> nodeHandler) {
		Stack<Node<T>> stack = new Stack<>();
		Node<T> curNode = node;
		while (curNode != null || !stack.isEmpty()) {
			while (curNode != null) {
				//先处理(中)
				nodeHandler.handler(curNode);
				//再入栈(栈内结点已处理)
				stack.push(curNode);
				//再找左结点(左)
				curNode = curNode.getLeftNode();
			}
			if (!stack.isEmpty()) {
				//左结点没有，或者左结点已处理，弹出一个栈内结点
				curNode = stack.pop();
				//看右结点是否存在(右)
				curNode = curNode.getRightNode();
			}
		}
	}

	/**
	 * 递归中序遍历(左中右)
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static <T extends Comparable<T>> void inOrderTraversal(Node<T> node, INodeHandler<T> nodeHandler) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeftNode(), nodeHandler);
		nodeHandler.handler(node);
		inOrderTraversal(node.getRightNode(), nodeHandler);
	}

	/**
	 * 非递归中序遍历(左中右)
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static <T extends Comparable<T>> void inOrderTraversalByLoop(Node<T> node, INodeHandler<T> nodeHandler) {
		Stack<Node<T>> stack = new Stack<>();
		Node<T> curNode = node;
		while (curNode != null || !stack.isEmpty()) {
			while (curNode != null) {
				//先入栈(栈内结点未处理)
				stack.push(curNode);
				//再找左结点(左)
				curNode = curNode.getLeftNode();
			}
			if (!stack.isEmpty()) {
				//左结点没有，或者左结点已处理，弹出一个栈内结点
				curNode = stack.pop();
				//处理(中)
				nodeHandler.handler(curNode);
				//看右结点是否存在(右)
				curNode = curNode.getRightNode();
			}
		}
	}

	/**
	 * 递归后序遍历(左右中)
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static <T extends Comparable<T>> void postOrderTraversal(Node<T> node, INodeHandler<T> nodeHandler) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.getLeftNode(), nodeHandler);
		postOrderTraversal(node.getRightNode(), nodeHandler);
		nodeHandler.handler(node);
	}

	/**
	 * 非递归后序遍历(左右中)
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static <T extends Comparable<T>> void postOrderTraversalByLoop(Node<T> node, INodeHandler<T> nodeHandler) {
		//先进后出
		Stack<Node<T>> stack = new Stack<>();
		Node<T> curNode = node, prevHandlerNode = null;
		while (curNode != null || !stack.isEmpty()) {
			//1、越左的结点，越后push进stack，弹出时就越快，越先处理
			while (curNode != null) {
				stack.push(curNode);
				curNode = curNode.getLeftNode();
			}
			
			if (!stack.isEmpty()) {
				Node<T> rightNode = stack.peek().getRightNode();
				//当左结点不存在，或者右结点是刚刚处理过的结点
				if (rightNode == null || rightNode == prevHandlerNode) {
					//弹出即处理
					curNode = stack.pop();
					nodeHandler.handler(curNode);
					//标记最近处理的结点为prevHandlerNode
					prevHandlerNode = curNode;
					//curNode处理后，它的左结点和右结点也必将处理过(如果存在的话)，所以不能让它回到第1步
					curNode = null;
				} else /*当前结点没有左结点，并且右结点存在并且不是前一个处理过的结点，将会在回到上面的第1步*/{
					curNode = rightNode;
				}
			}
		}
	}
}
