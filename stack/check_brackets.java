package org.q10viking.stackImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

//包含字符信息与在字符串位置的class
class Bracket{
	char type;
	int position;
	public Bracket(char type,int position) {
		this.type = type;
		this.position = position;
	}
	
	boolean Match(char c) {
		if(this.type=='(' && c == ')')
			return true;
		if(this.type=='{' && c == '}')
			return true;
		if(this.type=='[' && c == ']')
			return true;
		return false;
	}
}
public class check_brackets {

	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		
		Stack<Bracket> opening_brackets_stack = new Stack();
		//traverse the string
		for(int position=0;position<text.length();position++) {
			//Get current char
			char current = text.charAt(position);
			//if the current char is starting bracker,then push it to stack
			if(current=='(' || current=='[' || current=='{') {
				//create a Bracket(type,positioin) obj of starting bracker
				Bracket tmp = new Bracket(current,position);
				//push it to stack
				opening_brackets_stack.push(tmp);
			}
			
			if(current==')' || current==']' || current=='}') {
				//check stack is empty
				if(opening_brackets_stack.empty()) {
					System.out.println(position+1);  
					return;
				}
					
				//pop from stack
				Bracket item = opening_brackets_stack.pop();
				//test if the popped item is the matching starting bracker
				if(!item.Match(current)) {  //not match
					//print position of first unmatched closing bracker
					//now is the current
					System.out.println(position+1);  
					return;
				}
	
			}
			
		}
		
		if(opening_brackets_stack.isEmpty()) {
			System.out.println("Success");
		}else {
			Bracket item = opening_brackets_stack.pop();
			//print position of first unmatched opening bracket
			System.out.println(item.position+1);
		}
		
	}
	

}

/*
[]
Success

{}[]
Success

[()]
Success

{[]}()
Success

{
1

{[}
3

foo(bar);
Success

foo(bar[i);
10

*/



