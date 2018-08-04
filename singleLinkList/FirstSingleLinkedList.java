package org.q10viking.singleLinkList;

import java.util.HashSet;

public class FirstSingleLinkedList {

	Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){this.data = data; next = null;}
	}
	/* This function is in LinkedList class. Inserts a
	   new Node at front of the list. This method is 
	   defined inside LinkedList class shown above */
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node; 
	}
	
	/* This function is in LinkedList class.
	   Inserts a new node after the given prev_node. This method is 
	   defined inside LinkedList class shown above */
	public void insertAfter(Node pre_node,int new_data) {
		/* 1. Check if the given Node is null */
		if(pre_node == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		Node new_node = new Node(new_data);
		new_node.next = pre_node.next;
		pre_node.next = new_node;
	}
	
	/* Appends a new node at the end.  This method is 
	   defined inside LinkedList class shown above */
	
	public void append(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = null;
		/* If the Linked List is empty, then make the
        new node as head */
		if(head == null) {
			head = new_node;
			return;
		}
	 
		/* Else traverse till the last node */
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		return;
		
	}
	
	 /* Given a key, deletes the first occurrence of key in linked list */
	public void deleteNode(int key) {
		Node tmp = head,pre=null;
		
		if(head != null && head.data == key) {
			head = tmp.next;
			return;
		}
		
		while(tmp != null && tmp.data != key) {
			pre = tmp;
			tmp = tmp.next;
		}
		
		if(tmp==null) return;
		
		pre.next = tmp.next;
		tmp = null;
	}
	
	 /* Function deletes the entire linked list */
	public void deleteList() {
		head = null;
	}
	
	/*	print link list*/
	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println("");
	}
	
	/* Returns count of nodes in linked list */
	public int getCount() {
		Node tmp = head;
		int length=0;
		while(tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	
	//Checks whether the value x is present in linked list
	public boolean search(int x) {
		Node current = head;
		while(current!=null) {
			if(current.data == x)
				return true;
			current = current.next;
		}
		return false;
	}
	
	/* Takes index as argument and return data at index*/
	public int getNth(int x) {
		Node current = head;
		int index=0;
		while(current!=null) {
			if(index == x)
				return current.data;
			current = current.next;
			index++;
		}
		
		 /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
		assert(false);
		return 0;
	}
	
	/* Function to get the nth node from the last of a
    linked list */
	public void printNthFromLast(int n) {
		int length = getCount();
		int index = length-n;
		if(index<0)
			return;
		
		System.out.println(getNth(index));;
	}
	
	/* Function to get the middle of the linked list*/
	public void printMiddle() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		
		if(head == null)
			return;
		while(fast_ptr!=null && fast_ptr.next !=null) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}
		System.out.println("The middle element is ["+slow_ptr.data+"]");
	}
	
	// Returns true if there is a loop in linked
    // list else returns false.
	static boolean detectLoop(Node h) {
		HashSet<Node> s = new HashSet<Node>();
		Node current = h;
		while(current!=null) {
		/*     If we have already has this node
		     in hashmap it means their is a cycle
            (Because you we encountering the
             node second time).*/
			if(s.contains(current))
				return true;
			s.add(current);
			current = current.next;
		}
		
		return false;
	}
	
/*	Floyd’s Cycle-Finding Algorithm:*/
	public int detectLoop() {
		Node slow_ptr=head,fast_ptr=head;
		while(slow_ptr!=null && fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
			if(fast_ptr == slow_ptr) {
				System.out.println("Detected Loop");
				return countNodeInLoop(slow_ptr);
			}
		}
		System.out.println("No Loop");
		return 0;
	}
	
	/*Returns count of nodes present in loop.*/
	public int countNodeInLoop(Node slow_ptr) {
		int result=1;
		Node current = slow_ptr;
		while(current.next != slow_ptr) {
			result++;
			current = current.next;
		}
		return result;
	}
	public static void main(String[] args) {	
		//testEx_1();
		//testEx_2();
		//testEx_3();
		//testEx_4();
		//testEx_5();
		testEx_6();
		System.out.println("The end");
	}
	
	
	
	
	//=============================================================================================
	
	
	
	//Example 1:create a single linkedList and test
	public static void testEx_1() {
		FirstSingleLinkedList list = new FirstSingleLinkedList();
		
		list.head = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		
		list.head.next = second;
		
		second.next = third;
		list.printList();
	}
	
	//Example 2: test add node
	public static void testEx_2() {
		FirstSingleLinkedList list = new FirstSingleLinkedList();
		// Insert 6.  So linked list becomes 6->NUllist
		list.append(6);
		// Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
		list.push(7);
		// 1->7->6->NUllist
		list.push(1);
		// 1->7->6->4->NUllist
		list.append(4);
		// 1->7->8->6->4->NUllist
		
		list.insertAfter(list.head.next,8);
		list.printList();
	}
	
	//Example 3: delete node
	
	public static void testEx_3() {
		FirstSingleLinkedList list = new FirstSingleLinkedList();
		list.push(7);
		list.push(1);
		list.push(3);
		list.push(2);
		
		System.out.println("\nCreate link list is:");
		list.printList();
		System.out.println("The length of linked list: "+list.getCount());
		
		list.deleteNode(1);
	
		System.out.println("\nlink list after deletion:");
		list.printList();
		
		System.out.println("The length of linked list: "+list.getCount());
		
		System.out.println("Is the 7 presented in link list: "+list.search(7));
		System.out.println("Is the 1 presented in link list: "+list.search(1));
	}
	
	//Example 4: get Nth element
	public static void testEx_4() {
		FirstSingleLinkedList list = new FirstSingleLinkedList();
		list.push(7);
		list.push(1);
		list.push(3);
		list.push(2);
		System.out.println("\nCreate link list is:");
		list.printList();
		System.out.println("\nThe element of index 2 is:"+list.getNth(2));
		list.printNthFromLast(3);
		
	}
	
	//Example 5:print Middle element
	public static void testEx_5() {
		FirstSingleLinkedList list = new FirstSingleLinkedList();
		list.push(7);
		list.push(1);
		list.push(3);
		list.push(2);
		System.out.println("\nCreate link list is:");
		list.printList();
		list.printMiddle();
		
		list.append(8);
		list.append(5);
		list.push(6);
		System.out.println("\nCreate link list is:");
		list.printList();
		list.printMiddle();
		list.detectLoop();
		
	}
	
	//Example 6:detect loop
	public static void testEx_6() {
		FirstSingleLinkedList list = new FirstSingleLinkedList();
		list.push(7);
		list.push(1);
		list.push(3);
		list.push(2);
		list.head.next.next.next.next = list.head.next;
		if(detectLoop(list.head))
			System.out.println("Detected loop");
		else{
			System.out.println("No loop");
		}
		int result = list.detectLoop();
		
		if(result!= 0) {
			System.out.println("the length of Loop is: "+ result);
		}
	}

}
