package org.q10viking.stackImp;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackImpByLinkList {
	private LinkedList<Integer> datas = new LinkedList();
	
	boolean isEmpty() {
		return datas.isEmpty();
	}
	
	boolean push(int x) {
		datas.addFirst(x);
		return true;
	}
	
	Integer pop() {
		try {
			return datas.removeFirst();
		}catch(NoSuchElementException E) {
			System.out.println("Stack underFlow");
			return 0;
		}
	}
	public static void main(String[] args) {
		StackImpByLinkList stack = new StackImpByLinkList();
		stack.push(10);
		stack.push(20);
		
		stack.push(30);
		System.out.println(stack.pop()+" Popped from stack");
	}

}
/*
30 Popped from stack

*/