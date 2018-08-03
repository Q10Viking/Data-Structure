package org.q10viking.stackImp;

import java.util.Scanner;

public class BalancedParan {
	
	static class Stack{
		static final int MAX = 100;
		private int top=-1;
		char[] a = new char[MAX];
		
		boolean isEmpty() {
			return (top<0);
		}
		
		boolean push(char c) {
			if(top>=(MAX-1)) {
				System.out.println("Stack Overflow");
				return false;
			}else {
				a[++top]=c;
				return true;
			}
		}
		char pop() {
			if(isEmpty()) {
				System.out.println("Stack underflow");
				return '\0';
			}else {
				char tmp = a[top--];
				return tmp;
			}
		}
		
	}
	/* Returns true if character1 and character2
    are matching left and right Parenthesis */
	static boolean isMatchingPair(char charcter1,char charecter2) {
		if(charcter1=='{' && charecter2=='}')
			return true;
		if(charcter1=='(' && charecter2==')')
			return true;
		if(charcter1=='[' && charecter2==']')
			return true;
		return false;
	}
	
	static boolean areParenthesisBalanced(char[] exp) {
		Stack stack = new Stack();
		
		for(char c: exp) {
			if(c=='{' || c=='(' || c=='[') {
				stack.push(c);
			}
			
			if(c=='}' || c==']' || c==')') {
				if(stack.isEmpty()) return false;
				
				if(!isMatchingPair(stack.pop(),c)) {
					return false;
				}
			}
		}
		if(stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
	//	System.out.println("Start: ");
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		scanner.nextLine();
		while((T--)>0) {
			
			String exp = scanner.nextLine();
			boolean result = areParenthesisBalanced(exp.toCharArray());
			if(result) {
				System.out.println("balanced");
			}else{
				System.out.println("not balanced");
			}
			
		}
//		System.out.println("Over.");
	}

}
