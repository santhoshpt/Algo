package com.algo.tree;

public class TreeTraversal {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void printInOrder(Node root) {
		if (root.left != null)
			printInOrder(root.left);
		System.out.print(root.data + " ");
		if (root.right != null)
			printInOrder(root.right);
	}

	public static void printPreOrder(Node root) {
		System.out.print(root.data + " ");
		if (root.left != null)
			printPreOrder(root.left);
		if (root.right != null)
			printPreOrder(root.right);
	}
	
	public static void printPostOrder(Node root) {
		if (root.left != null)
			printPostOrder(root.left);
		if (root.right != null)
			printPostOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(5);
		root.left.right = new Node(6);

		System.out.println("\nIn order traversal");
		printInOrder(root);
		System.out.println("\nPre order traversal");
		printPreOrder(root);
		System.out.println("\nPost order traversal");
		printPostOrder(root);
	}

}
