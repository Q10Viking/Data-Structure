package org.q10viking.singleLinkList;

import java.util.Stack;

/*
1) Get the middle of the linked list.
2) Reverse the second half of the linked list.
3) Check if the first half and second half are identical.
4) Construct the original linked list by reversing the second half again and attaching it back to the first half

*/

public class PalindromeLinkList{
	Node head=null;
	
	static class Node{
		char data;
		Node next;
		Node(char d){
			data = d;
			next = null;
		}
	}
	
	Node slow_ptr,fast_ptr,second_half;
	
	/* Function to check if given linked list is
    palindrome or not */
	
	boolean isPalindromeLinkList(Node head) {
		slow_ptr = head;
		fast_ptr = head;
		Node prev_of_slow_ptr=null;
		boolean res=true;
		Node midnode=null;
		if(head != null && head.next != null) {
			
			while(fast_ptr != null && fast_ptr.next !=null) {
				/*We need previous of the slow_ptr for
                linked lists  with odd elements */
				prev_of_slow_ptr = slow_ptr;
				slow_ptr = slow_ptr.next;
				fast_ptr = fast_ptr.next.next;
			}
			
			/*
			 * fast_ptr would become null when there are even elements
			 * in the list and not null for odd elements.We need to skip
			 * the middle node for odd case and store it somewhere so that 
			 * we can restore the origianl list
			 * 
			 */
			
			if(fast_ptr != null) {
				midnode = slow_ptr;
				slow_ptr = slow_ptr.next;
			}
			
			second_half = slow_ptr;
			prev_of_slow_ptr.next = null;
			
			 // Now reverse the second half and compare it with first half
			reverse();
			res = compareLists(head,second_half);
			
			//restore the link
			reverse();
			if(midnode != null) {
				prev_of_slow_ptr.next = midnode;
				midnode.next = second_half;
			}else {
				prev_of_slow_ptr.next = second_half;
			}
			

		}

		return res;
	}
	
	/*Function to reverse the linked list */
	void reverse() {
		Node prev = null;
		Node current = second_half;
		Node next;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		second_half=prev;
		
	}
	
	/*Function to check if two input lists have same data*/
	boolean compareLists(Node head1,Node head2) {
		Node tmp1 = head1;
		Node tmp2 = head2;
		while(tmp1 != null && tmp2 != null) {
			if(tmp1.data != tmp2.data)
				return false;
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		  /* Both are empty return true*/
		if(tmp1 == null && tmp2 == null)
			return true;
	    /* Will reach here when one is NULL
        and other is not */
		return false;
	}
	
	public void push(char c) {
		Node new_node = new Node(c);
		new_node.next = head;
		head = new_node;
	}
	
	public void printList(Node ptr) {
		Node current = ptr;
		while(current!=null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println("null");
	}
	
	
	//================================================
	//Method2:use stack T(n),O(n)
	public boolean isPalindromeLinkList(){
		Stack<Character> stack = new Stack();
		Node current = head;
		boolean result= true;
		// Traverse the given list from head to tail and push every visited node to stack.
		while(current!=null) {
			Character c = current.data;
			stack.push(c);
			current = current.next;
		}
		
		//Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
		current = head;
		while(current !=null ) {
			if(stack.pop() != current.data) {
				result = false;
				break;
			}
			current = current.next;
		}
		
		//If all nodes matched, then return true, else false.
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		PalindromeLinkList list = new PalindromeLinkList();
		char str[] = {'a', 'b', 'a', 'c', 'a', 'b', 'a'};
		String string = new String(str);
		for(int i=0;i<string.length();i++) {
			list.push(str[i]);
			list.printList(list.head);
			if(list.isPalindromeLinkList(list.head)) {
				System.out.println("Is Palindrome");
				System.out.println("");
			}else {
				System.out.println("Not Palindrome");
				System.out.println("");
			}
			
			System.out.println("Method 2 test: ");
			
			if(list.isPalindromeLinkList()) {
				System.out.println("Is Palindrome");
				System.out.println("");
			}else {
				System.out.println("Not Palindrome");
				System.out.println("");
			}
			
			System.out.println("=============================");
		}
		
		System.out.println("The end");
	}

}




/*
a->null
Is Palindrome

b->a->null
Not Palindrome

a->b->a->null
Is Palindrome

c->a->b->a->null
Not Palindrome

a->c->a->b->a->null
Not Palindrome

b->a->c->a->b->a->null
Not Palindrome

a->b->a->c->a->b->a->null
Is Palindrome

The end
*/





