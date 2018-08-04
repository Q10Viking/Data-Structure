package org.q10viking.test;
import java.util.LinkedList;
import java.util.Stack;

public class ParameterTest {
	int a=9;
	
	public void f(int aa) {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		ParameterTest t = new ParameterTest();
		int a = 10;
		LinkedList<Character> list = new LinkedList();
		Stack stack = new Stack();
		boolean flag=true;
		list.addLast('a');
		list.addLast('b');
		list.addLast('a');
		System.out.println(list);
		
		for(Character c:list) {
			stack.push(c);
		}
		
		for(int i=0;i<list.size();i++) {
			if(stack.pop() != list.get(i)) {
				flag = false;
				break;
			}		
			//System.out.println(i);
		}
		
		
		if(flag) {
			System.out.println("是");
		}else {
			System.out.println("否");
		}
		
	}

}
 