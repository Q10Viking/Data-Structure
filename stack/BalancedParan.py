'''
Created on 2018年8月3日
https://practice.geeksforgeeks.org/problems/parenthesis-checker/0
@author: Viking
'''

n = int(input())
j = 0
while j < n:
    s = input()
    stack = []
    balanced = True
    i = 0
    while i < len(s):
        if s[i] == '[' or s[i] == '{' or s[i] == '(':
            stack.append(s[i])
        else:
            if len(stack) == 0:
                balanced = False
                break
            a = stack.pop()
            if((s[i] == ']' and a != '[') or (s[i] == '}' and a != '{') or (s[i] == ')' and a != '(')):
                balanced = False
                break
        i = i + 1

    if balanced and len(stack) == 0:
        print("balanced")
    else:
        print("not balanced")

    j = j + 1
