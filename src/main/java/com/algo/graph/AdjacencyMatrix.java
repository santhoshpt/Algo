package com.algo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class AdjacencyMatrix {

	private int[][] graph;
	private boolean[] visited;
	private Stack<Integer> stack;
	private int noOfNodes;

	public void initializeGraph(int noOfNodes) {
		this.noOfNodes = noOfNodes;
		stack = new Stack<Integer>();
		graph = new int[noOfNodes][noOfNodes];
		visited = new boolean[noOfNodes];
		for (int i = 0; i < noOfNodes; i++) {
			for (int j = 0; j < noOfNodes; j++) {
				graph[i][j] = 0;
			}
		}
	}

	public void resetVisited() {
		for (int i = 0; i < noOfNodes; i++) {
			visited[i] = false;
		}
	}

	public void generateGraph() throws NumberFormatException, IOException {
		System.out.println("Enter number of edges\n");
		int noOfEdges = getInt();
		System.out.println("Enter pair of directed nodes for an edge\n");
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < noOfEdges; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			graph[m][n] = 1;
		}
	}

	public void printGraph() {
		for (int i = 0; i < noOfNodes; i++) {
			System.out.print("Node" + i + " ");
			for (int j = 0; j < noOfNodes; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println("");
		}
	}

	public void printTopologicalOrder() {
		resetVisited();
		// check adjacency for each node
		for (int i = 0; i < noOfNodes; i++) {
			if (visited[i] == false) {
				getNoEdgeNode(i);
			}
		}
		System.out.println("Topological ordering");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
			System.out.print("");
		}
	}

	public void getNoEdgeNode(int index) {
		for (int i = 0; i < noOfNodes; i++) {
			if (graph[index][i] == 1 && visited[i] == false) {
				getNoEdgeNode(i);
			}
		}
		stack.push(index);
		visited[index] = true;
	}

	public int getInt() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		AdjacencyMatrix adjacenyMatix = new AdjacencyMatrix();
		System.out.println("Enter number of nodes\n");
		int noOfNodes = adjacenyMatix.getInt();
		adjacenyMatix.initializeGraph(noOfNodes);
		adjacenyMatix.generateGraph();
		adjacenyMatix.printGraph();
		adjacenyMatix.printTopologicalOrder();
	}
}
