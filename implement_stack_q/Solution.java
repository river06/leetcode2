class MyStack {
	private Queue<Integer> my_q = new LinkedList<Integer>();
	
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> tmp = new LinkedList<Integer>();
		while( !my_q.isEmpty() ) {
			tmp.add( my_q.remove() );
		}
		my_q.add(x);
		while( !tmp.isEmpty() ) {
			my_q.add( tmp.remove() );
		}
    }

    // Removes the element on top of the stack.
    public void pop() {
        my_q.remove();
    }

    // Get the top element.
    public int top() {
        return my_q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return my_q.isEmpty();
    }
}
