package com.bsc.algorithm.data.tree;

import java.util.Stack;

public class BinaryTree {

	/**
	 * �ݹ�ǰ�����
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static void preOrderTraversal(Node node, INodeHandler nodeHandler) {
		if (node == null) {
			return;
		}
		nodeHandler.handler(node);
		preOrderTraversal(node.getLeftNode(), nodeHandler);
		preOrderTraversal(node.getRightNode(), nodeHandler);
	}

	/**
	 * �ǵݹ�ǰ�����
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static void preOrderTraversalByLoop(Node node, INodeHandler nodeHandler) {
		Stack<Node> stack = new Stack<>();
		Node curNode = node;
		while (curNode != null || !stack.isEmpty()) {
			while (curNode != null) {
				nodeHandler.handler(curNode);
				stack.push(curNode);
				curNode = curNode.getLeftNode();
			}
			if (!stack.isEmpty()) {
				curNode = stack.pop();
				curNode = curNode.getRightNode();
			}
		}
	}

	/**
	 * �ݹ��������
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static void inOrderTraversal(Node node, INodeHandler nodeHandler) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeftNode(), nodeHandler);
		nodeHandler.handler(node);
		inOrderTraversal(node.getRightNode(), nodeHandler);
	}

	/**
	 * �ǵݹ��������
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static void inOrderTraversalByLoop(Node node, INodeHandler nodeHandler) {
		Stack<Node> stack = new Stack<>();
		Node curNode = node;
		while (curNode != null || !stack.isEmpty()) {
			while (curNode != null) {
				stack.push(curNode);
				curNode = curNode.getLeftNode();
			}
			if (!stack.isEmpty()) {
				curNode = stack.pop();
				nodeHandler.handler(curNode);
				curNode = curNode.getRightNode();
			}
		}
	}

	/**
	 * �ݹ�������
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static void postOrderTraversal(Node node, INodeHandler nodeHandler) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.getLeftNode(), nodeHandler);
		postOrderTraversal(node.getRightNode(), nodeHandler);
		nodeHandler.handler(node);
	}

	/**
	 * �ǵݹ�������
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static void postOrderTraversalByLoop(Node node, INodeHandler nodeHandler) {
		Stack<Node> stack = new Stack<>();
		Node curNode = node, prevNode = node;
		while (curNode != null || !stack.isEmpty()) {
			while (curNode != null) {
				stack.push(curNode);
				curNode = curNode.getLeftNode();
			}
			if (!stack.isEmpty()) {
				Node rightNode = stack.peek().getRightNode();
				if (rightNode == null || rightNode == prevNode) {
					curNode = stack.pop();
					nodeHandler.handler(curNode);
					prevNode = curNode;
					curNode = null;
				} else {
					curNode = rightNode;
				}
			}
		}
	}
}
