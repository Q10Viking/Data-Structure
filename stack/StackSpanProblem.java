package org.q10viking.stackImp;
import java.util.Arrays;
import java.util.Stack;

public class StackSpanProblem {
	
	static int[] calculateSpan(int[] price) {
		Stack<Integer> stack = new Stack();
		int[] result = new int[price.length];
		//span value of first day is always 1
		result[0]=1;
		stack.push(0);
		//Calculate span value of remaining days by linearly checking previous,找下标
		//栈顶比自己小的都出栈，直到比自己大的，然后将自己的下表加入栈
		for(int i=1;i<price.length;i++) {
			//注意price[stack.peek()]
			while(!stack.isEmpty() && price[stack.peek()]<=price[i]) {
				stack.pop();
			}
			//If stack becomes empty,the price[i] is greater than all elements
			//Else price[i] is greater than elements after top of stak.
			result[i] = stack.isEmpty()?i+1:i-stack.peek();
			//Push this element to stack
			stack.push(i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] price =  {100, 80, 60, 70, 60, 75, 85};
		int[] result=calculateSpan(price);
		System.out.println(Arrays.toString(result));
	}

}

/*
[1, 1, 1, 2, 1, 4, 6]
*/