package com.algo.tree;

public class MaxAtLevel {
	
	static class Node {
		int data;
		Node left, right;
		Node(int key) {
			data = key;
			left = right = null;
		}
	}
	
	public static void inOrder(Node tmp) {
		if(tmp == null) return;
		inOrder(tmp.left);
		System.out.print(tmp.data + " ");
		inOrder(tmp.right);
	}
	
	public static int maxAtLevel(Node tmp, int level) {
		if(tmp == null) {
			return 0;
		}
		if(level == 0) {
			return tmp.data;
		}
		int a = maxAtLevel(tmp.left, level-1);
		int b = maxAtLevel(tmp.right, level-1);
		
		return (a > b)?a:b;
	}
	
	public static void main(String args[]) {
		
		Node root = null;
		root = new Node(45); 
	    root.left = new Node(46); 
	    root.left.left = new Node(18); 
	    root.left.left.left = new Node(16); 
	    root.left.left.right = new Node(23); 
	    root.left.right = new Node(17); 
	    root.left.right.left = new Node(24); 
	    root.left.right.right = new Node(21); 
	    root.right = new Node(15); 
	    root.right.left = new Node(22); 
	    root.right.left.left = new Node(37); 
	    root.right.left.right = new Node(41); 
	    root.right.right = new Node(19); 
	    root.right.right.left = new Node(49); 
	    root.right.right.right = new Node(29); 
	  
	    inOrder(root);
	    int level = 2; 
		
	    System.out.println("\nMaximum at level("+level+") is "+maxAtLevel(root, level));
		
	}

}
