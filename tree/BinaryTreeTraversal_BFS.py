'''
Created on 2018年8月4日
https://www.geeksforgeeks.org/level-order-tree-traversal/
@author: Viking
'''
# python3 orgram to print level order traversal using queue


class Node:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None


def printLevelOrder(root):
    if root is None:
        return

    # create an empty queue for level order traversal
    queue = []

    queue.append(root)
    while(len(queue) > 0):
        tmp = queue.pop(0)
        print(tmp.data, end=" ")
        if tmp.left is not None:
            queue.append(tmp.left)
        if tmp.right is not None:
            queue.append(tmp.right)


# Driver code to test above function
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

print("Level Order Traversal of binary tree is -")
printLevelOrder(root)

'''
Level Order Traversal of binary tree is -
1 2 3 4 5 
'''
