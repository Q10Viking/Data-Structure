'''
Created on 2018年8月4日
https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
@author: Viking
'''


class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


# create root
root = Node(1)
''' following is the tree after above statement
        1
      /   \
     None  None'''
root.left = Node(2)
root.right = Node(3)
''' 2 and 3 become left and right children of 1
           1
         /   \
        2      3
     /    \    /  \
   None None None None'''
root.left.left = Node(4)
'''4 becomes left child of 2
           1
       /       \
      2          3
    /   \       /  \
   4    None  None  None
  /  \
None None'''
