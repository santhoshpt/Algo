package com.algo.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpSearch {
	
	private int item[];
	private int jump = -1;
	
	public void readItems(int noOfElements, BufferedReader br) throws IOException {
		item = new int[noOfElements];
		for(int i = 0; i<noOfElements; i++ ){
			System.out.print("Enter the element for " + i +" index: ");
			item[i]=Integer.parseInt(br.readLine());
		}
	}
	
	public int jumpSearch(int item[], int start, int end, int key, int jump) {
		int currentJump = -1;
		for (int i = jump; i <= end; i = i + jump) {
			currentJump = i;
			System.out.println("Jump = "+ i);
			if(key <= item[i]) {
				return (currentJump - jump);
			}
		}
		if (key <= item[end]) {
			return currentJump;
		}
		return -1;
	}
	
	public int findKey(int key) {
		jump = (int) Math.sqrt(new Integer(item.length).doubleValue());
		int jumpStart = jumpSearch(item, 0, item.length-1, key, jump);
		if(jumpStart > -1) {
			int last = -1;
			if(jumpStart + jump > item.length) {
				last = item.length;
			} else {
				last = jumpStart + jump;
			}
			for(int i = jumpStart; i<=last; i++) {
				if(key == item[i]) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static void main(String arg[]) throws IOException{
		JumpSearch ls = new JumpSearch();
		System.out.print("Enter number of elements in sorted order for the Array to be searched for: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
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