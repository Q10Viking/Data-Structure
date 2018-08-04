package org.q10viking.queue;

//Java program for array implementation of queue

public class QueueImpByArray {
	int array[];
	int capacity;
	int front,rear; 
	int size;
	
	public QueueImpByArray(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity-1;
		array = new int[capacity];
	}
	
	
	//Queue is full when size becomes equal to the capacity
	boolean isFull() {
		return size==capacity;
	}
	
	
	//Queue is empty when size is 0
	boolean isEmpty() {
		return size==0;
	}
	
	//Method to add an element to the queue
	//It change rear and size
	void enqueue(int item) {
		if(isFull()) {
			return;
		}
		//循环利用
		this.rear = (this.rear+1)%this.capacity;
		array[rear]=item;
		this.size += 1;
	}
	
	
	//Method to remove an item from queue
	//It change front and size
	int dequeue() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int item = array[front];
		this.front = (this.front+1)%capacity;
		this.size -= 1;
		return item;
	}
	
	
	int front() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return array[front];
	}
	
	int rear() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return array[rear];
	}
	
	public static void main(String[] args) {
		QueueImpByArray queue = new QueueImpByArray(4);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		
		queue.enqueue(50);
		System.out.println("front: "+queue.front()+" rear: "+queue.rear());
		queue.dequeue();
		queue.enqueue(50);
		System.out.println("front: "+queue.front()+" rear: "+queue.rear());
	}

}

/*
front: 10 rear: 40
front: 20 rear: 50

*/