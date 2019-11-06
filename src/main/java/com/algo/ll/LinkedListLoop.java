package com.algo.ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class LinkedListLoop {
	
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
		LinkedListLoop ll = new LinkedListLoop();
		
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
				
		ll.head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next =  second;
		ll.printList();
	}
	
	public String getString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	
	public int getInt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}
	
	public boolean detectLoop() {
		boolean isLoopFound = false;
		HashSet visit = new HashSet();
		Node temp = head;
		while(temp != null) {
			System.out.println("Adding the element to HastSet" + temp.data);
			if(!visit.add(temp.data)) {
				isLoopFound = true;
				break;
			}
			temp = temp.next;
		}
		return isLoopFound;
	}
	
	public boolean countOfLoop() {
		System.out.println("Floyd's scann for loop");
		boolean isLoop = false;
		Node slow, fast;
		slow = fast = head;
		while(slow != null && slow.next!=null && fast!=null && fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println("Slow pointer "+slow.data);
			System.out.println("Fast pointer "+fast.data);
			if(slow.data == fast.data) {
				isLoop = true;
				break;
			}
		}
		if(isLoop) {
			Node temp = slow;
			int count = 1;
			while(slow.next != temp) {
				count++;
				slow = slow.next;
			}
			System.out.println("Count of loop is " + count);
		}
		
		
		return isLoop;
	}
	
	public void dectectAndRemoveLoop() {
		System.out.println("Floyd's scann for loop");
		Node slow, fast;
		slow = fast = head;
		while(slow != null && slow.next!=null && fast!=null && fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println("Slow pointer "+slow.data);
			System.out.println("Fast pointer "+fast.data);
			if(slow.data == fast.data) {
				slow.next = null;
			}
		}
	}
	
	
	public void printList() {
		if(detectLoop()) {
			System.out.println("Can't print the list as it as loop in it");
			//return;
		}
		if(countOfLoop()) {
			System.out.println("Can't print the list as it as loop in it [by floyd's allgorithm]");
			//return;
		}
		dectectAndRemoveLoop();
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