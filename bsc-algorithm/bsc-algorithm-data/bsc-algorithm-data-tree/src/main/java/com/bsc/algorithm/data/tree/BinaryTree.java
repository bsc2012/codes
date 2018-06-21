package com.bsc.algorithm.data.tree;

import java.util.Stack;

public class BinaryTree {

	/**
	 * 递归前序遍历
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
	 * 非递归前序遍历
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
	 * 递归中序遍历
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
	 * 非递归中序遍历
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
	 * 递归后序遍历
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
	 * 非递归后序遍历(左右根)
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static void postOrderTraversalByLoop(Node node, INodeHandler nodeHandler) {
		//先进后出
		Stack<Node> stack = new Stack<>();
		Node curNode = node, prevHandlerNode = null;
		while (curNode != null || !stack.isEmpty()) {
			//1、越左的结点，越后push进stack，弹出时就越快，越先处理
			while (curNode != null) {
				stack.push(curNode);
				curNode = curNode.getLeftNode();
			}
			
			if (!stack.isEmpty()) {
				Node rightNode = stack.peek().getRightNode();
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
