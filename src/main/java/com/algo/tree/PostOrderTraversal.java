package com.algo.tree;

public class PostOrderTraversal {

	public void printPostOrder(int in[], int pre[], int inStart, int inEnd, int preIndex) {

		if (inStart > inEnd) {
			return;
		}
		int root = search(in, inStart, inEnd, pre[preIndex++]);

		printPostOrder(in, pre, inStart, root - 1, preIndex);

		printPostOrder(in, pre, root + 1, inEnd, preIndex);

		System.out.print(in[root] + " ");
	}

	public static int search(int arr[], int startIndex, int endIndex, int data) {
		int i = 0;
		for (i = startIndex; i < endIndex; i++) {
			if (arr[i] == data) {
				return i;
			}
		}
		return i;
	}

	public static void main(String args[]) {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		int length = in.length;
		PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
		postOrderTraversal.printPostOrder(in, pre, 0, length - 1, 0);
	}

}
