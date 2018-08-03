package org.q10viking.stackImp;

import java.util.Stack;

public class StackImpByArray {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];
	
	StackImpByArray() {
		top = -1;
	}
	
	boolean isEmpty() {
		return (top<0);
	}
	
	int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return 0;
		}else {
			
			int x = a[top--];
			return x;
		}
	}
	
	boolean push(int x) {
		if(top>=(MAX-1)) {
			System.out.println("Stack Overflow");
			return false;
		}else {
			a[++top]=x;
			return true;
		}
		
	}
	
	
	public static void main(String[] args) {
		StackImpByArray s = new StackImpByArray();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop()+" Popped from stack.");
		
	}

}

/*
30 Popped from stack.

*/