'''
Created on 2018年8月4日
https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
@author: Viking
'''

# python3 program to do inorder traversal without recursion
# by use Stack


class Node:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None


def Inorder(root):
    stack = []
    current = root
    while ((current is not None) or (len(stack) > 0)):
        while current is not None:
            stack.append(current)
            current = current.left

        current = stack.pop()
        print(current.data, end=" ")
        current = current.right

# Driver program to test above function


""" Constructed binary tree is
            1
          /   \
         2     3
       /  \
      4    5   """

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

Inorder(root)


'''
4 2 5 1 3 
'''
