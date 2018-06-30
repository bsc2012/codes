package com.bsc.algorithm.data.tree;

import java.util.Stack;

public class BinaryTree {

	/**
	 * �ݹ�ǰ�����(������)
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
	 * �ǵݹ�ǰ�����(������)
	 * 
	 * @param node
	 * @param nodeHandler
	 */
	public static void preOrderTraversalByLoop(Node node, INodeHandler nodeHandler) {
		Stack<Node> stack = new Stack<>();
		Node curNode = node;
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
	public static void inOrderTraversal(Node node, INodeHandler nodeHandler) {
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
	public static void inOrderTraversalByLoop(Node node, INodeHandler nodeHandler) {
		Stack<Node> stack = new Stack<>();
		Node curNode = node;
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
	public static void postOrderTraversal(Node node, INodeHandler nodeHandler) {
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
	public static void postOrderTraversalByLoop(Node node, INodeHandler nodeHandler) {
		//�Ƚ����
		Stack<Node> stack = new Stack<>();
		Node curNode = node, prevHandlerNode = null;
		while (curNode != null || !stack.isEmpty()) {
			//1��Խ��Ľ�㣬Խ��push��stack������ʱ��Խ�죬Խ�ȴ���
			while (curNode != null) {
				stack.push(curNode);
				curNode = curNode.getLeftNode();
			}
			
			if (!stack.isEmpty()) {
				Node rightNode = stack.peek().getRightNode();
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
