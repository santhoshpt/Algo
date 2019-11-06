package com.algo.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeSort {
	
	private int elements[];
	private int length;
	
	public void readElements() throws Exception {
		System.out.println("Enter elements to be sorted");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] strElements = line.split(" ");
		length = strElements.length;
		elements = new int[length];
		for(int i=0; i<length; i++) {
			elements[i] = Integer.parseInt(strElements[i]);
		}
	}
	
	public void printElements() {
		for(int i=0; i<length;i++) {
			System.out.print(elements[i]+" ");
		}
	}
	
	public void sortElements() {
		mergeSort(0, length-1);
	}
	
	public void mergeSort(int start, int end) {
		if(end > start) {
			int middle = (start + end)/2;
			mergeSort(start, middle);
			mergeSort(middle+1, end);
			merge(start, middle, end);
		}
	}
	
	public void merge(int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;
		int l[] = new int[n1];
		int r[] = new int[n2];
		
		for(int i = 0; i<n1; i++) {
			l[i] = elements[left + i];
		}
		
		for(int i = 0; i<n2; i++) {
			r[i] = elements[middle + 1 + i];
		}
		
		int i = 0; //index for first array
		int j = 0; //index for second array
		int k = left; //index for actual array
		
		while(i < n1 && j < n2) {
			if(l[i] <= r[j]) {
				elements[k] = l[i];
				i++;
			} else {
				elements[k] = r[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			elements[k] = l[i];
			k++;
			i++;
		}
		
		while(j < n2) {
			elements[k] = r[j];
			j++;
			k++;
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		MergeSort mSort = new MergeSort();
		mSort.readElements(); 
		System.out.println("\nBefore Sorting");
		mSort.printElements();
		mSort.sortElements();
		System.out.println("\nAfter Sorting");
		mSort.printElements();
	}
}
