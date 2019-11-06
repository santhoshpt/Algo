package com.algo.generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Test {

	private int[][] graph;
	private boolean[] visited;
	private Stack<Integer> stack;
	private int noOfIslands;
	private int noOfBridges;
	private int startedInIsland;
	Scanner in = new Scanner(System.in);

	public void initializeGraph() {
		stack = new Stack<Integer>();
		graph = new int[noOfIslands + 1][noOfIslands + 1];
		visited = new boolean[noOfIslands + 1];
		for (int i = 0; i < noOfIslands + 1; i++) {
			for (int j = 0; j < noOfIslands + 1; j++) {
				graph[i][j] = 0;
			}
		}
	}

	public void resetVisited() {
		for (int i = 0; i < noOfIslands + 1; i++) {
			visited[i] = false;
		}
	}

	public void printGraph() {
		for (int i = 1; i <= noOfIslands; i++) {
			System.out.print("IsLand-" + i + " ");
			for (int j = 1; j <= noOfIslands; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println("");
		}
	}

	public void printFirstLonelyInIsland() {
		resetVisited();
		// check adjacency for each node
		int start = startedInIsland;

		for (int i = start; i <= noOfIslands; i++) {
			calculateLonelyIslands(i);
		}
		while (!stack.isEmpty()) {
		//if (!stack.isEmpty()) {
			System.out.print(stack.pop());
			System.out.print("");
		}
	}

	private void calculateLonelyIslands(int index) {
		boolean noEdge = false;
		for (int i = 1; i <= noOfIslands; i++) {
			if (graph[index][i] == 1) {
				noEdge = true;
				calculateLonelyIslands(i);
			}
		}
		if (!noEdge) {
			stack.push(index);
		}
	}

	public int getInt() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}

	public void captureInput() {
		noOfIslands = in.nextInt();
		noOfBridges = in.nextInt();
		startedInIsland = in.nextInt();
	}

	public void generateGraph() throws NumberFormatException, IOException {
		for (int i = 0; i < noOfBridges; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			graph[m][n] = 1;
		}
	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		Test islandPb = new Test();
		// System.out.println("Enter number of nodes\n");
		islandPb.captureInput();
		islandPb.initializeGraph();
		islandPb.generateGraph();
		//islandPb.printGraph();
		islandPb.printFirstLonelyInIsland();
	}
}
