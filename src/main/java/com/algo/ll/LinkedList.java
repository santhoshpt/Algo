package com.algo.ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public static void main(String args[]) throws IOException {
		LinkedList ll = new LinkedList();
		
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		ll.head = first;
		first.next = second;
		second.next = third;
		third.next = null;
		
		int element, nodeData;
		
		while(true) {
			ll.printList();
			System.out.println("\n Enter choice:");
			System.out.println("1 -> Insert at start of the list");
			System.out.println("2 -> Insert at end of the list");
			System.out.println("3 -> Insert after a node in the list");
			System.out.println("4 -> Delete a node from the list");
			System.out.println("5 -> Find the position of the node in list");
			System.out.println("8 -> Find the length of the list");
			System.out.println("9 -> Quit");
			int choice  = ll.getInt();
			switch (choice) {
				case 1:
					System.out.println("Enter node data");
					element = ll.getInt();
					ll.insertBegining(element);
					break;
				case 2:
					System.out.println("Enter node data");
					element = ll.getInt();
					ll.insertEnd(element);
					break;
				case 3:
					System.out.println("Enter node data");
					element = ll.getInt();
					System.out.println("Enter the node data to be inserted after");
					nodeData = ll.getInt();
					ll.insertAfter(element, nodeData);
					break;
				case 4:
					System.out.println("Enter the key for the node to delete");
					element = ll.getInt();
					ll.deleteNode(element);
					break;		
				case 5:
					System.out.println("Enter the key for finding its position in the list");
					element = ll.getInt();
					ll.findNode(element);
					break;
					
				case 8:
					System.out.println("Length of the list is "+ll.getLength());
					break;
				case 9:
					break;
			}
			if(choice == 9) {
				break;
			}
		}
	}
	
	public String getString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	
	public int getInt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}
	
	public void printList() {
		System.out.print("Linked list values -> ");
		for(Node temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.data + " ");
		}
		System.out.println("");
	}
	
	public void findNode(int key) {
		Node temp = head;
		int position = 0;
		while(temp!=null && temp.data!=key) {
			temp = temp.next;
			position++;
		}
		if(temp == null) {
			System.out.println("Node does not exists in the list");
		} else {
			System.out.println("Given node found at position, " + position);
		}
	}
	
	public int getLength() {
		int position = 0;
		Node temp = head;
		while(temp != null) {
			position++;
			temp = temp.next;
		}
		return position;
	}
	
	public void deleteNode(int key) {
		
		Node previous = null;
		Node temp = head;
		if(temp.data == key) {
			head = temp.next;
			temp = null;
		}
		while(temp!=null) {
			if(temp.data == key) {
				previous.next = temp.next;
				temp = null;
				break;
			}
			previous = temp;
			temp = temp.next;
		}
	}
	
	public void insertBegining(int d) {
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertEnd(int d) {
		
		Node newNode = new Node(d);
		if(head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	public void insertAfter(int value, int d) {
		if(head == null) {
			System.out.println("The list is empty");
			return;
		}
		Node temp = head;
		while (temp != null) {
			if(temp.data == d) {
				Node newNode = new Node(value);
				newNode.next = temp.next;
				temp.next = newNode;
				break;
			}
			temp = temp.next;
		}
	}
}