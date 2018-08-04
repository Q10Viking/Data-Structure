'''
Created on 2018年8月4日
https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
@author: Viking
'''


# python3 program for array implementation of queue

# class Queue to represent a queue

class Queue:
     # __init__ function

    def __init__(self, capacity):
        self.front = self.size = 0
        self.rear = capacity - 1
        self.Q = [None] * capacity
        self.capacity = capacity

    def isFull(self):
        return self.size == self.capacity

    def isEmpty(self):
        return self.size == 0

    def Enqueue(self, item):
        if self.isFull():
            return
        self.rear = (self.rear + 1) % self.capacity
        self.Q[self.rear] = item
        self.size = self.size + 1

    def Dequeue(self):
        if self.isEmpty():
            return
        item = self.Q[self.front]
        self.front = (self.front + 1) % self.capacity
        self.size = self.size - 1
        return item

    def que_front(self):
        if self.isEmpty():
            print("Queue is Empty")
        else:
            print("Front item is", self.Q[self.front])

    def que_rear(self):
        if self.isEmpty():
            print("Queue is Empty")
        else:
            print("Rear item is", self.Q[self.rear])


# Driver Code
if __name__ == '__main__':
    queue = Queue(3)
    queue.Enqueue(10)

    queue.Enqueue(20)
    queue.Enqueue(30)
    queue.Enqueue(40)

    queue.que_front()
    queue.que_rear()

'''
Front item is 10
Rear item is 30
'''