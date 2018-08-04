package org.q10viking.stackImp;
import java.util.Stack;
//前缀表达式转中缀表达式
public class InfixToPostfix {
	
	//A utility function to return precedence(优先级) of a given operator
	//Higher returned value means higher precedence
	static int Prec(char c) {
		switch (c){
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
		}
		return -1;
	}
	
	//The main method that converts given infix expression
	//to postfix expression
	static String infixToPostfix(String exp) {
		//initializing empty StringBuilder for result
		StringBuilder result = new StringBuilder();
		
		//initialing empty stack
		Stack<Character> stack = new Stack();
		
		
		char[] expChar = exp.toCharArray();
		//scan the exp
		for(char ch: expChar) {
			
			//if the scanned character is an operand,add it to output
			if(Character.isLetterOrDigit(ch))
				result.append(ch);
			
			//处理括号：
			else if(ch=='(')
				stack.push(ch);
			
			//If the scanneed character is an ')',pop and output from the stack
			//util an '(' is encountered
			
			else if(ch==')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				if(stack.isEmpty() || stack.peek() != '(') {
					return "Invalid Expression";
				}
				
				stack.pop();
				
			}
			//an operator is encountered
			else {
				while(!stack.isEmpty() && Prec(ch) <= Prec(stack.peek()))
					result.append(stack.pop());
				
				stack.push(ch);
			}

			
		}
		
		//pop all the operation from the stack
		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}
		
	
		return result.toString();
	}
	
	
	public static void main(String[] args) {
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix(infix));
	}

}

/*
abcd^e-fgh*+^*+i-

*/