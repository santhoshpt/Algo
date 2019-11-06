package com.algo.heap;

public class MinHeapArray {

	int heapSize = 0;
	int capacity = 0;
	int hArray[];
	
	public MinHeapArray(int capacity) {
		this.heapSize = 0;
		this.capacity = capacity;
		hArray = new int[capacity];
		
	}
	
	public void insertKey(int key) {
		if(capacity == heapSize) {
			System.out.println("Head overflow");
		}
		if(heapSize == 0) {
			heapSize ++;
			hArray[heapSize -1] = key;
		} else {
			heapSize ++;
			int i = heapSize - 1;
			hArray[i] = key;
			while(i!=0 && (hArray[parent(i)] > hArray[i]) ) {
				swap(parent(i), i);
				i = parent(i);
			}
		}
	}
	
	public void deleteKey(int key) {
		if(heapSize == 0 && key > heapSize-1) {
			System.out.println("Head underflow");
		}
		
		if(key == heapSize -1) {
			hArray[key] = -1;
			heapSize --;
		} else {
			hArray[key] = hArray[heapSize-1];
			heapSize--;
			minHeapify(key);
		}
		
	}

	
	public int parent(int key) {
		return (key - 1) / 2;
	}
	
	public int left(int key) {
		return (2 * key) + 1;
	}
	
	public int right(int key) {
		return (2 * key) + 2;
	}
	
	
	public int extractMin() {
		int root  = -1;
		if(heapSize == 0) {
			System.err.println("Underflow");
		} else if(heapSize == 1) {
			heapSize --;
			root = hArray[0];
		} else {
			root = hArray[0];
			hArray[0] = hArray[heapSize-1];
			heapSize--;
			minHeapify(0);
		}
		return root;
	}
	
	
	public int getMin() {
		return hArray[0];
	}
	
	public void decreaseKey(int i, int new_value) {
		hArray[i] = new_value;
		while(i != 0 && hArray[parent(i)] > hArray[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}
	
	public void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if(l < heapSize && hArray[l] < hArray[i]) {
			smallest = l;
		}
		if(r < heapSize && hArray[r] < hArray[smallest]) {
			smallest = r;
		}
		if(smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
		
	}
	
	public void swap(int i, int j) {
		int temp = hArray[i];
		hArray[i] = hArray[j];
		hArray[j] = temp;
	}
	
	public void displayHeap() {
		System.out.print("Heap -> ");
		for(int i= 0; i<heapSize; i++) {
			System.out.print(hArray[i]+" ");
		}
	}
	public static void main(String args[]) {
		MinHeapArray h = new MinHeapArray(11);
		/*
		 * 
		 h.insertKey(3);
		 h.insertKey(2);
		 h.deleteKey(1);
		 h.insertKey(15);
		 h.insertKey(5);
		 h.insertKey(4);
		 h.insertKey(45);
		 */
		h.insertKey(9);
		h.insertKey(3);
		h.insertKey(6);
		h.insertKey(8);
		h.insertKey(5);
		h.insertKey(1);
		
		 h.displayHeap();
		 /*
		 System.out.println("\nExtract Minimum "+h.extractMin());
		 h.displayHeap();
		 System.out.println("\nGet Minimum "+h.getMin());
		 h.displayHeap();
		 h.decreaseKey(2, 1);
		 System.out.println("\nGet Minimum "+h.getMin());
		 h.displayHeap();*/
	}
	
}
