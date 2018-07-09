package com.bsc.algorithm.data.tree;

import java.util.Stack;

public class BinaryTree{

	/**
	 * �ݹ�ǰ�����(������)
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
	 * �ǵݹ�ǰ�����(������)
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
				//�ȴ���(��)
				nodeHandler.handler(curNode);
				//����ջ(ջ�ڽ���Ѵ���)
				stack.push(curNode);
				//��������(��)
				curNode = curNode.getLeftNode();
			}
			if (!stack.isEmpty()) {
				//����û�У����������Ѵ�������һ��ջ�ڽ��
				curNode = stack.pop();
				//���ҽ���Ƿ����(��)
				curNode = curNode.getRightNode();
			}
		}
	}

	/**
	 * �ݹ��������(������)
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
	 * �ǵݹ��������(������)
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static <T extends Comparable<T>> void inOrderTraversalByLoop(Node<T> node, INodeHandler<T> nodeHandler) {
		Stack<Node<T>> stack = new Stack<>();
		Node<T> curNode = node;
		while (curNode != null || !stack.isEmpty()) {
			while (curNode != null) {
				//����ջ(ջ�ڽ��δ����)
				stack.push(curNode);
				//��������(��)
				curNode = curNode.getLeftNode();
			}
			if (!stack.isEmpty()) {
				//����û�У����������Ѵ�������һ��ջ�ڽ��
				curNode = stack.pop();
				//����(��)
				nodeHandler.handler(curNode);
				//���ҽ���Ƿ����(��)
				curNode = curNode.getRightNode();
			}
		}
	}

	/**
	 * �ݹ�������(������)
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
	 * �ǵݹ�������(������)
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static <T extends Comparable<T>> void postOrderTraversalByLoop(Node<T> node, INodeHandler<T> nodeHandler) {
		//�Ƚ����
		Stack<Node<T>> stack = new Stack<>();
		Node<T> curNode = node, prevHandlerNode = null;
		while (curNode != null || !stack.isEmpty()) {
			//1��Խ��Ľ�㣬Խ��push��stack������ʱ��Խ�죬Խ�ȴ���
			while (curNode != null) {
				stack.push(curNode);
				curNode = curNode.getLeftNode();
			}
			
			if (!stack.isEmpty()) {
				Node<T> rightNode = stack.peek().getRightNode();
				//�����㲻���ڣ������ҽ���Ǹոմ�����Ľ��
				if (rightNode == null || rightNode == prevHandlerNode) {
					//����������
					curNode = stack.pop();
					nodeHandler.handler(curNode);
					//����������Ľ��ΪprevHandlerNode
					prevHandlerNode = curNode;
					//curNode���������������ҽ��Ҳ�ؽ������(������ڵĻ�)�����Բ��������ص���1��
					curNode = null;
				} else /*��ǰ���û�����㣬�����ҽ����ڲ��Ҳ���ǰһ��������Ľ�㣬�����ڻص�����ĵ�1��*/{
					curNode = rightNode;
				}
			}
		}
	}
}
