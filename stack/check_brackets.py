'''
Created on 2018年8月4日

@author: Viking
'''
import sys
# python3 program check brackets in the code


class Bracket:
    def __init__(self, type, position):
        self.type = type
        self.position = position

    def Match(self, c):
        if self.type == '(' and c == ')':
            return True
        if self.type == '[' and c == ']':
            return True
        if self.type == '{' and c == '}':
            return True
        return False


if __name__ == '__main__':
    text = input()
    opening_brackets_stack = []

    for i, next in enumerate(text):
        if next == '(' or next == '[' or next == '{':
            opening_brackets_stack.append(Bracket(next, i))
        if next == ')' or next == ']' or next == '}':
            if len(opening_brackets_stack) <= 0:
                print(i + 1)
                sys.exit()
            item = opening_brackets_stack.pop()
            if not item.Match(next):
                print(i + 1)
                sys.exit()

    if len(opening_brackets_stack) == 0:
        print("Success")
    else:
        print(opening_brackets_stack.pop().position + 1)
