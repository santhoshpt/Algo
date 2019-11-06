package com.algo.tree;

public class TreeWithArray {
	
	static class ArrayImpl {
		static int root = 0;
		static String[] str = new String[10];
		
		ArrayImpl(String key) {
			str[0] = key;
		}
		
		public void addLeft(String key, int parent) {
			if(str[parent] == null) {
				System.out.printf("Can't set child at %d, no parent found", parent);
			} else {
				int child = (2*parent) + 1;
				str[child] = key;
			}
		}
		
		public void addRight(String key, int parent) {
			if(str[parent]==null) {
				System.out.printf("Can't set child at %d, no parent found", parent);
			} else {
				int child = (2*parent) + 2;
				str[child] = key;
			}
		}
		
		public void printTree() {
			for(int i=0; i<10; i++) {
				if(str[i] == null) {
					System.out.print("- ");
				} else {
					System.out.print(str[i] + " ");
				}
			}
		}
		
	}
	
	
	public static void main(String args[]) {
		ArrayImpl aTree= new ArrayImpl("A");
		aTree.addLeft("B", 0);
		aTree.addRight("C", 0);
		aTree.addLeft("D", 1);
		aTree.addRight("E", 1);
		//aTree.addLeft("F", 2);
		aTree.addRight("G", 2);
		aTree.printTree();
		
		
	}

}
