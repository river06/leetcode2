import java.util.*;
class MinStack {

    /** initialize your data structure here. */
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
		minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
		if (minStack.isEmpty() || minStack.peek() >= x) {
			minStack.push(x);
		}
    }
    
    public void pop() {
        int x = stack.pop();
		if (!minStack.isEmpty() && minStack.peek() == x) {
			minStack.pop();
		}
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
