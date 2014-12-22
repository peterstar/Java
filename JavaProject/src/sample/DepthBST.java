package sample;

// find depth of Binary search tree
// find if the BST is balanced
public class DepthBST {
	
}

class BinaryTree {
	private Node root;
	
	private static class Node {
		Node left;
		Node right;
		int data;
		
		Node(int num) {
			left = null;
			right = null;
			data = num;
		}		
	}
	
	public BinaryTree() {
		root = null;
	}
	
	public boolean lookup(int data) {
		return lookup(root, data);
	}
	
	private boolean lookup(Node node, int data){
		if(node == null) return false;
		if(data == node.data) return true;
		if(data < node.data) return lookup(node.left, data);
		else return lookup(node.right, data); 
	}
	
	public void insert(int data){
		root = insert(root, data);
	}
	
	private Node insert(Node node, int data){
		if(node == null) {
			node = new Node(data);
		} else {
			if(data <= node.data)
				node = insert(node.left, data);
			else
				node = insert(node.right, data);
		}
		return node;
	}
	
	// build 123 tree
	public void build123() {
		root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
	}
	
	// Returns the number of nodes in the tree
	public int size() {
		return size(root);
	}
	
	private int size(Node node){
		if(node == null) 
			return 0;
		else
			return size(node.left) + 1 + size(node.right);
	}
	
	// Returns the max root-to-leaf depth of the tree
	public int maxDepth() {
		return maxDepth(root);
	}
	
	private int maxDepth(Node node){
		if(node == null) { 
			return 0;
		} else {
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);
			// use the larger + 1 
			return Math.max(leftDepth, rightDepth) + 1;
		}			
	}
	
	// Returns the min value in a non-empty binary search tree		
	public int minDepth() {
		return minDepth(root);
	}
	
	private int minDepth(Node node){
		Node current = node;
		while(current.left != null){
			current = current.left;
		}
		return current.data;
	}
		
	// Prints the node values
	public void printTree() {
		
		
		
	}
}


