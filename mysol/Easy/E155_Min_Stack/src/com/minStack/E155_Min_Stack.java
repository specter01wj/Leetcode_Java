package com.minStack;
import java.util.*;

/*Design a stack that supports push, pop, top, and retrieving 
 the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

public class E155_Min_Stack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		int getmin1 = minStack.getMin();
		minStack.pop();
		minStack.top();
		int getmin2 = minStack.getMin();
        System.out.println("getMin: " + (getmin1) + "\noutput: " + (getmin2));
	}
	
	/*
    solution:
    使用两个仅支持 pop 和 push 的栈就可以完成, stack 储存压入的数据, minStack 储存最小值.
    
	push 直接把元素压入 stack, 对于 minStack, 如果它为空则直接压入, 
			反之压入当前元素与 minStack 栈顶的最小值
	pop 两个栈都弹出一个元素, 返回 stack 弹出的元素
	min 返回 minStack 的栈顶
    */
	static class MinStack {

	    /** initialize your data structure here. */
	    private Stack<Integer> stack;
	    private int min;
	    
	    public MinStack() {
	        stack = new Stack<Integer>();
	        min = Integer.MAX_VALUE;
	    }
	    
	    /*
	     * @param number: An integer
	     * @return: nothing
	     */
	    public void push(int x) {
	        if (x <= min) {
	            stack.push(min);
	            min = x;
	        }
	        stack.push(x);
	    }
	    
	    /*
	     * @return: An integer
	     */
	    public void pop() {
	        int tmp = stack.pop();
	        if (tmp == min) {
	            min = stack.pop();
	        }
	    }
	    
	    /*
	     * @return: An integer
	     */
	    public int top() {
	        return stack.peek();
	    }
	    
	    /*
	     * @return: An integer
	     */
	    public int getMin() {
	        return min;
	    }
	}

}
