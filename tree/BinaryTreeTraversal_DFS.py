'''
Created on 2018年8月4日
https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
@author: Viking
'''

# python3 program to for tree traversals


class Node:
    def __init__(self, key):
        self.key = key
        self.left = self.right = None


def Inorder(node):
    if node:
        Inorder(node.left)
        print(node.key, end=" ")
        Inorder(node.right)


def Preorder(node):
    if node:
        print(node.key, end=" ")
        Preorder(node.left)
        Preorder(node.right)


def Postorder(node):
    if node:
        Postorder(node.left)
        Postorder(node.right)
        print(node.key, end=" ")


# Driver code
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

print("Inorder中序遍历: ", end="\n")
Inorder(root)
print("\nPreorder先序遍历：")
Preorder(root)
print("\nPostorder后序遍历：")
Postorder(root)

'''
Inorder中序遍历: 
4 2 5 1 3 
Preorder先序遍历：
1 2 4 5 3 
Postorder后序遍历：
4 5 2 3 1 
'''
