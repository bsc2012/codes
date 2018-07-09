
import com.bsc.algorithm.data.tree.BinaryTree;
import com.bsc.algorithm.data.tree.INodeHandler;
import com.bsc.algorithm.data.tree.Node;

public class Test {

	public static void main(String[] args) {
		Node<Integer> I = new Node<Integer>(8, null, null);
		Node<Integer> H = new Node<Integer>(4, null, null);
		Node<Integer> G = new Node<Integer>(2, null, null);
		Node<Integer> F = new Node<Integer>(7, null, I);
		Node<Integer> E = new Node<Integer>(5, H, null);
		Node<Integer> D = new Node<Integer>(1, null, G);
		Node<Integer> C = new Node<Integer>(9, F, null);
		Node<Integer> B = new Node<Integer>(3, D, E);
		Node<Integer> A = new Node<Integer>(6, B, C);

		INodeHandler<Integer> nodeHandler= (Node<Integer> node)->{
			System.out.print(node.getData() + "\t");
		};
		BinaryTree.preOrderTraversal(A, nodeHandler);
		System.out.println();
		BinaryTree.preOrderTraversalByLoop(A, nodeHandler);
		System.out.println();
		BinaryTree.inOrderTraversal(A, nodeHandler);
		System.out.println();
		BinaryTree.inOrderTraversalByLoop(A, nodeHandler);
		System.out.println();
		BinaryTree.postOrderTraversal(A, nodeHandler);
		System.out.println();
		BinaryTree.postOrderTraversalByLoop(A, nodeHandler);
	}
}
