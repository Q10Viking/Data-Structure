package org.q10viking.singleLinkList;
import static org.q10viking.singleLinkList.FirstSingleLinkedList.Node;

import java.util.Scanner;
/*delete xth node in single Linked list*/
public class GFG {
	
	static Node deleteNode(Node head,int x) {
		Node tmp = head,pre=null;
		if(head==null)
			return null;
		
		if(x==1) {
			head = head.next;
			return head;
		}
		
		x = x-1;
		while(x!=0 && tmp != null) {
			pre = tmp;
			tmp = tmp.next;
			x--;
		} 
		
		if(tmp == null) return head;
		
		pre.next = tmp.next;
		tmp=null;
		return head;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T!=0) {
			int N = sc.nextInt();

			FirstSingleLinkedList list = new FirstSingleLinkedList();
			for(int i=0;i<N;i++) {
				list.append(sc.nextInt());
			}
			int x = sc.nextInt();
			
			list.head = deleteNode(list.head,x);
			list.printList();
			
			T--;
		}
		
		
		
		
	}
}
