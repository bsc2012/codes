
import com.bsc.algorithm.data.tree.BinaryTree;
import com.bsc.algorithm.data.tree.INodeHandler;
import com.bsc.algorithm.data.tree.Node;

public class Test {

	public static void main(String[] args) {
		Node J = new Node(8, null, null);
		Node H = new Node(4, null, null);
		Node G = new Node(2, null, null);
		Node F = new Node(7, null, J);
		Node E = new Node(5, H, null);
		Node D = new Node(1, null, G);
		Node C = new Node(9, F, null);
		Node B = new Node(3, D, E);
		Node A = new Node(6, B, C);

		INodeHandler nodeHandler= (Node node)->{
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
