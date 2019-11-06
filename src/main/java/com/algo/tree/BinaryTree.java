package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	static class Node {
		int data;
		Node left, right;
		public Node(int key) {
			data = key;
			left = right = null;
		}
		
		public String toString() {
			return "Key-> " + data;
		}
	}
	
	static Node root = null;
	
	public static void inOrder(Node tmp) {
		if(tmp == null) return;
		inOrder(tmp.left);
		System.out.print(tmp.data + " ");
		inOrder(tmp.right);
	}
	
	public static void preOrder(Node tmp) {
		if(tmp == null) return;
		System.out.print(tmp.data + " ");
		preOrder(tmp.left);
		preOrder(tmp.right);
	}
	
	public static void postOrder(Node tmp) {
		if(tmp == null) return;
		postOrder(tmp.left);
		postOrder(tmp.right);
		System.out.print(tmp.data + " ");
	}
	
	public static void insertWithBFS(Node tmp, int key) {
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(tmp);
		
		while(!queue.isEmpty()) {
			tmp = queue.remove();
			if(tmp.left == null) {
				tmp.left =  new Node(key);
				return;
			} else {
				queue.add(tmp.left);
			}
			
			if(tmp.right == null) {
				tmp.right = new Node(key);
				return;
			} else {
				queue.add(tmp.right);
			}
		}
	}
	
	public static Node findNode(Node tmp, int key) {
		if(tmp == null) {
			return tmp;
		}
		
		Node tmp2 =  findNode(tmp.left, key);
		if(tmp2 != null) {
			return tmp2;
		}
		if(tmp.data == key) {
			return tmp;
		}
		return findNode(tmp.right, key);
	}
	/*
	public static boolean isNodeExists(Node tmp, int key) {
		if(tmp == null) {
			return false;
		}
		if(tmp.data == key) {
			return true;
		}
		if(key < tmp.data) {
			return isNodeExists(tmp.left, key);
		}
		if (key > tmp.data) {
			return isNodeExists(tmp.right, key);
		}
		return false;
	}*/
	
	public static void deleteNode(int key) {
		Node tmp = findNode(root, key);
		if(tmp.data == key) {
			if(tmp.left != null && tmp.left.right == null) {
				tmp.data = tmp.left.data;
				tmp.left = tmp.left.left;
			} else  if(tmp.left !=null && tmp.left.left == null) {
				tmp.data = tmp.left.data;
				tmp.left =  tmp.left.right;
			} else if (tmp.right != null && tmp.right.right == null) {
				tmp.data = tmp.right.data;
				tmp.left = tmp.right.left;
			} else if (tmp.right != null && tmp.right.left == null) {
				tmp.data = tmp.right.data;
				tmp.left = tmp.right.right;
			} else {
				Node parent = tmp;
				while(parent.right != null) {
					parent = parent.right;
				}
			}
		} else {
			inOrder(tmp.left);
			inOrder(tmp.right);
		}
	}
	
	public static void printTreeWithStack() {
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		
		while(current!=null || stack.size()>0) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
	}
	

	public static void main(String args[]) {
		
		root = new Node(10);
		root.left = new Node(11);
		root.left.left = new Node(7);
		root.right =  new Node(9);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		System.out.println("Tree traversal before insertion");
		inOrder(root);
		System.out.println("\nTree traversal[stack] before insertion");
		printTreeWithStack();
		/*
		System.out.println("");
		if(isNodeExists(root, 8)) {
			System.out.println("Node with key as 8 exists in tree");
		} else {
			System.out.println("Node with key as 8 does not exists in tree");
		}*/
		
		insertWithBFS(root, 12);
		//System.out.println("\n\nTree traversal after insertion");
		//inOrder(root);
		//deleteNode(10);
		//System.out.println("\n\nTree traversal after deletion");
		//inOrder(root);
		
		//System.out.println("\n\n The key "+15+"found at node " + findNode(root, 15));
	}
}
