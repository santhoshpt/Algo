package com.algo.search;

import java.io.IOException;
import java.util.Scanner;

public class VowelsSearch {

	int noOfTestCases;
	String[] treesArray;
	char[] keys = new char[] { 'A', 'E', 'I', 'O', 'U' };

	public VowelsSearch(int noOfTesCases, String[] trees) {
		this.noOfTestCases = noOfTesCases;
		this.treesArray = trees;
	}

	public void findKeysCount(String trees) {
		int length = trees.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			char tree = trees.charAt(i);
			if (tree == 'A' || tree == 'E' || tree == 'I' || tree == 'O' || tree == 'U') {
				count++;
			}
		}
		System.out.println(count);
	}

	public void findCountOfKeysInTestCases() {
		for (int i = 0; i < noOfTestCases; i++) {
			findKeysCount(treesArray[i]);
		}
	}

	public static void main(String arg[]) throws IOException {

		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		String[] trees = new String[noOfTestCases];
		for (int i = 0; i < noOfTestCases; i++) {
			trees[i] = new String(in.next().toUpperCase());
			//System.out.println(trees[i]);
		}
		in.close();
		VowelsSearch serach = new VowelsSearch(noOfTestCases, trees);
		serach.findCountOfKeysInTestCases();
	}
}