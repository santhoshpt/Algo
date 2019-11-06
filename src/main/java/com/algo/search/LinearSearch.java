package com.algo.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearSearch {
	
	private int item[];
	
	public void readItems(int noOfElements, BufferedReader br) throws IOException {
		item = new int[noOfElements];
		for(int i = 0; i<noOfElements; i++ ){
			System.out.print("Enter the element for " + i +" index: ");
			item[i]=Integer.parseInt(br.readLine());
		}
	}
	
	public int findKey(int key) {
		int index = -1;
		for (int i = 0; i<item.length; i++) {
			if(key == item[i]){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void main(String arg[]) throws IOException{
		LinearSearch ls = new LinearSearch();
		System.out.print("Enter number of elements for the list to be searched for: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		ls.readItems(size, br);
		System.out.print("Enter element to be searched  -> ");
		int key = Integer.parseInt(br.readLine());
		int foundAt = ls.findKey(key);
		if(foundAt > -1) {
			System.out.println("The element is found at index " + foundAt);
		} else {
			System.out.println("The element does not exists in the list");
		}
	}
}