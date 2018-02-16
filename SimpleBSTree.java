package syed.example;

import java.util.Queue;

class BSTreeNode {
	int data;
	BSTreeNode left, right;
	
	public BSTreeNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
	
	public BSTreeNode getLeftNode() {
		return this.left;
	}
	
	public BSTreeNode getRightNode() {
		return this.right;
	}
	
}

public class SimpleBSTree {
	BSTreeNode root;


	public void insertIntoBSTree(int data) {
		if(root.data == 0 && root.left == null && root.right == null)  {
			root.data = data;
			return;
		}
		insertIntoBSTree(this.root, data);
	}
	
	void insertIntoBSTree(BSTreeNode root, int data) {

		BSTreeNode node = root, prev = null;
		while(node != null) {
			prev = node;
			if(node.data > data) node = node.left;
			else if(node.data < data) node = node.right;
		}
		if(prev!=null) {
			if(prev.data > data) prev.left = new BSTreeNode(data);
			else prev.right = new BSTreeNode(data);
		}
		
	}
	
	void printTreeInOrder(BSTreeNode root) {
		if(root == null)
			return;
		
		printTreeInOrder(root.left);
		System.out.print(""+root.data+" >> ");
		printTreeInOrder(root.right);
		
	}
	
	public static void main(String[] args) {
		
		SimpleBSTree tree = new SimpleBSTree();
		tree.root = new BSTreeNode(0);
		int tmp[] = {10, 12, 14, 8, 6, 1, 20, 5, 18};
		for(int i=0; i< tmp.length; i++) {
			tree.insertIntoBSTree(tmp[i]);
		}
		System.out.print("Tree : ");
		tree.printTreeInOrder(tree.root);
		System.out.println("\n");
	}

}
