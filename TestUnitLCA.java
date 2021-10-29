import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnitLCA {

	@Test
	public void test() {
		BinaryTree bt = new BinaryTree(); 
		bt.root = new Node(1); 
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		//Test for LCA = 2 for nodes 4,5 
		assertEquals(bt.findLCA(4, 5).data, 2); 
		//Test for non-existent LCA between 4, 10 in param 2
		assertEquals(bt.findLCA(4, 10), null); 
		//Test for non-existent LCA between 10, 2 in param 1
		assertEquals(bt.findLCA(10, 2), null); 
		//Test for root = LCA
		assertEquals(bt.findLCA(7, 4), bt.root);
		//Test on DSG with 2 nodes sharing same 2 parents (same length)
		bt = new BinaryTree(); 
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3); 
		bt.root.left.right = new Node(4); 
		bt.root.right.left = bt.root.left.right; 
		bt.root.right.right = new Node(5);
		bt.root.left.left = bt.root.right.right;
		assertEquals(bt.findLCA(4, 5).data, 2);
		//Test on DSG where lengths are different 
		bt = new BinaryTree(); 
		bt.root = new Node(1); 
		bt.root.left = new Node(2);
		bt.root.left.left = new Node(4); 
		bt.root.right = new Node(3); 
		bt.root.right.left = new Node(5);
		bt.root.right.left.left = new Node(7);
		bt.root.right.left.right = new Node(8); 
		bt.root.right.right = new Node(6);
		bt.root.left.left.left = bt.root.right.right; 
		assertEquals(bt.findLCA(6, 7).data, 3); 
		
	}

}
