'''
Created on 2018年8月4日
https://www.geeksforgeeks.org/queue-set-2-linked-list-implementation/
@author: Viking
'''
# python3 program to demonstrate linked list
# based implementation of queue


# A linked list(LL) node
# to store a queue entry
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


# The queue,front stores the front node
# of LL and rear stores the last node of LL
class Queue:
    def __init__(self):
        self.rear = self.front = None

    def isEmpty(self):
        return self.front == None

    def enqueue(self, item):
        tmp = Node(item)

        if self.rear == None:
            self.rear = self.front = tmp
            return

        self.rear.next = tmp
        self.rear = tmp

    def dequeue(self):
        if self.isEmpty():
            return

        tmp = self.front
        self.front = self.front.next

        if self.front == None:
            self.rear = None

        return str(tmp.data)


# Driver code
if __name__ == '__main__':
    queue = Queue()
    queue.enqueue(10)
    queue.enqueue(20)
    queue.dequeue()
    queue.dequeue()
    queue.enqueue(30)
    queue.enqueue(40)
    queue.enqueue(50)
    print("Dequeued item is " + queue.dequeue())


'''
Dequeued item is 30
'''
