import java.util.*;

class MaxStack {

	class Node {
		Node linkedNode = null;
		Node prev = null;
		Node next = null;
		int timeStamp = 0;
		int value = 0;
		Node (int value, int timeStamp) {
			this.value = value;
			this.timeStamp = timeStamp;
		}
	}
	
	/* propreties */
	Node dummyHead;
	Node dummyTail;
	PriorityQueue<Node> maxHeap;
	int timeStamp;

	boolean isDebug = false;
	
    /** initialize your data structure here. */
    public MaxStack() {
		timeStamp = 0;
        dummyHead = new Node(0, 0);
		dummyTail = new Node(0, 0);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
		maxHeap = new PriorityQueue<Node> (new Comparator<Node>() {
			public int compare (Node a, Node b) {
				if (a.value != b.value) {
					return b.value - a.value;
				} else {
					return b.timeStamp - a.timeStamp;
				}
			}
		});
    }
    
    public void push(int x) {
		// create nodes and build connection between nodes
		timeStamp++;
		Node n1 = new Node(x, timeStamp);
		Node n2 = new Node(x, timeStamp);
		n1.linkedNode = n2;
		n2.linkedNode = n1;
		
        // push to double linked list
		insertTop(n1);

		// push to max heap
		maxHeap.offer(n2);
    }
    
    public int pop() {
        Node n1 = dummyHead.next;
		removeNode(n1);
		maxHeap.remove(n1.linkedNode);
		if (isDebug) { System.out.println(n1.value); }
		return n1.value;
    }
    
    public int top() {
		if (isDebug) { System.out.println(dummyHead.next.value); }
        return dummyHead.next.value;
    }
    
    public int peekMax() {
		if (isDebug) { System.out.println(maxHeap.peek().value); }
        return maxHeap.peek().value;
    }
    
    public int popMax() {
        Node n2 = maxHeap.poll();
		removeNode(n2.linkedNode);
		if (isDebug) { System.out.println(n2.value); }
		return n2.value;
    }

	private void insertTop(Node node) {
		Node nextNode = dummyHead.next;
		dummyHead.next = node;
		nextNode.prev = node;
		node.prev = dummyHead;
		node.next = nextNode;
	}

	private void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
