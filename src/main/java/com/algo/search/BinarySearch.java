package com.algo.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
	
	private int item[];
	
	public void readItems(int noOfElements, BufferedReader br) throws IOException {
		item = new int[noOfElements];
		for(int i = 0; i<noOfElements; i++ ){
			System.out.print("Enter the element for " + i +" index: ");
			item[i]=Integer.parseInt(br.readLine());
		}
	}
	
	public int binarySearch(int item[], int left, int right, int key) {
		int mid = (right + left) /  2;
		if(key < item[mid]) {
			return binarySearch(item, left, mid-1, key);
		} else if (key > item[mid]) {
			return binarySearch(item, mid+1, right, key);
		} else if (key == item[mid]) {
			return mid;
		} 	
		return -1;
		
	}
	
	public int findKey(int key) {
		return binarySearch(item, 0, item.length-1, key);
	}
	
	public static void main(String arg[]) throws IOException{
		BinarySearch ls = new BinarySearch();
		System.out.print("Enter number of elements for the Array to be searched for: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		System.out.println("Size of Array is " + size);
		ls.readItems(size, br);
		System.out.print("Enter element to search -> ");
		int key = Integer.parseInt(br.readLine());
		int foundAt = ls.findKey(key);
		if(foundAt > -1) {
			System.out.println("The element found at index " + foundAt);
		} else {
			System.out.println("The element does not exists in the Array");
		}
	}
}