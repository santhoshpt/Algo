package com.algo.search;

import java.io.IOException;
import java.util.Scanner;

public class SubArrayProblem {

	int noOfIntegers;
	int[] intArray;

	public SubArrayProblem(int noOfIntegers, int[] intArray) {
		this.noOfIntegers = noOfIntegers;
		this.intArray = intArray;
	}

	public void findMaxCost() {
	}

	public static void main(String arg[]) throws IOException {

		Scanner in = new Scanner(System.in);
		int noOfIntegers = in.nextInt();
		int[] ints = new int[noOfIntegers];
		for (int i = 0; i < noOfIntegers; i++) {
			ints[i] = in.nextInt();
		}
		in.close();
		SubArrayProblem serach = new SubArrayProblem(noOfIntegers, ints);
		serach.findMaxCost();
	}
}