package org.q10viking.queue;

//A linked list node to store a queue entry
//链表的核心是Node
class QNode{
	int key;
	QNode next;
	QNode(int key){
		this.key = key;
		this.next = null;
	}
	
}

//The queue,front stores the front node of LL and rear stores the 
//Last node of LL(Link list)
public class QueueImpByLinkList {

	QNode rear,front;
	public QueueImpByLinkList() {
		this.front = this.rear = null;
	}
	
	//Method to add an key to the queue
	public void enqueue(int key) {
		//create a new LL node
		QNode tmp = new QNode(key);
		//If queue is empty,then new node is front and rear both
		if(this.rear==null) {
			this.front=this.rear=tmp;
			return ;
		}
		//add the new node at the end of queue and change rear
		this.rear.next = tmp;
		this.rear = tmp;
		
	}
	//Method to remove an key from queue
	public int dequeue() {
		if(this.front == null)
			return 0;
		QNode tmp = this.front;
		this.front = this.front.next;

		//if front becomes null,then change rear also null
		if(this.front==null) {
			this.rear = null;
		}
		return tmp.key;
	}
	
	
	public static void main(String[] args) {
		QueueImpByLinkList queue = new QueueImpByLinkList();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}

/*
10
20
30

*/