'''
Created on 2018年8月3日
https://www.geeksforgeeks.org/the-stock-span-problem/
@author: Viking
'''


def calculateSpan(price, S):
    n = len(price)
    # create a stack and push index of first element of it
    st = []
    st.append(0)

    # span value of first element is always 1
    S[0] = 1

    # Calculate span values for rest of the elements
    for i in range(1, n):
        while(len(st) > 0 and price[st[-1]] <= price[i]):
            st.pop()

        S[i] = i + 1 if len(st) <= 0 else (i - st[-1])

        # push this element to stack
        st.append(i)

# A utility function to print elements of array


def printArray(arr, n):
    for i in range(n):
        print(arr[i], end=" ")


# Driver program to test above function
price = [100, 80, 60, 70, 60, 75, 85]
S = [0 for i in range(len(price))]
print(S)
# fill the span values in array S[]
calculateSpan(price, S)

# print the span values
printArray(S, len(price))


'''
1 1 1 2 1 4 6 
'''