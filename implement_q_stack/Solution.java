import java.util.*;

class MyQueue {

	private Stack<Integer> stack = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
		Stack<Integer> tmp = new Stack<Integer>();
		while( !stack.isEmpty() ) {
			tmp.push( stack.pop() );
		}
		stack.push( x );
		while( !tmp.isEmpty() ) {
			stack.push( tmp.pop() );
		}
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}
