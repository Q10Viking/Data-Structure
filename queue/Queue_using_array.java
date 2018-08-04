package org.q10viking.queue;

import java.util.Scanner;

//题目： https://practice.geeksforgeeks.org/problems/implement-queue-using-array/1
public class Queue_using_array {
	int front,rear;
	int arr[] = new int[1000];
	Queue_using_array() {
		front = rear = 0;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			
			GFG obj = new GFG();
			Queue_using_array qn = new Queue_using_array();
			int Q = sc.nextInt();
			while(Q>0) {
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType==1) {
					int a = sc.nextInt();
					obj.push(a,qn);
				}else if(QueryType==2) {
					System.out.print(obj.pop(qn)+" ");
				}
				Q--;
			
			}
			
			System.out.println();
			
			t--;
		}
	}
}


class GFG{
	/* The method push to push element into the queue */
	void push(int a, Queue_using_array ob)
	{
		ob.arr[ob.rear]=a;
		ob.rear = (ob.rear+1)%1000;
	} 
      /*The method pop which return the element poped out of the queue*/
	int pop(Queue_using_array ob)
	{
		if(ob.front==ob.rear)
			return -1;
		int item = ob.arr[ob.front];
		ob.front = (ob.front+1)%1000;
		return item;
	} 
}

/*
For Input:
2
20
2 2 1 40 2 1 68 2 1 28 1 85 1 21 1 23 2 1 82 1 85 1 73 1 51 2 2 1 100 1 43 1 14 
9
1 43 1 97 2 1 12 1 16 2 1 33 1 51 2
Your Output is:
-1 -1 40 68 28 85 21 
43 97 12 

*/
