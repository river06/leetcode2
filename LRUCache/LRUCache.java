import java.util.*;
public class LRUCache {
	/**
	 * node class. Double linked list
	 */
	class Node {
		Node prev;
		Node next;
		int val;
		int key;
		
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.prev = null;
			this.next = null;
		}
			
	}

	private int capacity;
	public Node dummyHead;
	private Node dummyTail;
	private Map<Integer, Node> key2Node;
	
    /**
	 * @param capacity: An integer
	 */
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.dummyHead = new Node(0, 0);
		this.dummyTail = new Node(0, 0);
		this.dummyHead.next = this.dummyTail;
		this.dummyTail.prev = this.dummyHead;
		this.key2Node = new HashMap<Integer, Node>();
	}

    /**
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
		if (!key2Node.containsKey(key)) { return -1; }
		Node node = key2Node.get(key);
		int val = node.val;

		removeNode(node);
		insertHead(node);

		return val;
    }

    /**
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (key2Node.containsKey(key)) {
			Node node = key2Node.get(key);

			removeNode(node);
			insertHead(node);
			node.val = value;
		} else {
			if (key2Node.size() >= capacity) {
				int removeKey = dummyTail.prev.key;
				removeNode(dummyTail.prev);
				key2Node.remove(removeKey);
			}
			Node node = new Node(key, value); 
			insertHead(node);
			key2Node.put(key, node);
		}
    }

	private void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		node.prev = null;
		node.next = null;
	}

	private void insertHead(Node node) {
		Node nextNode = dummyHead.next;
		dummyHead.next = node;
		node.prev = dummyHead;
		nextNode.prev = node;
		node.next = nextNode;
	}
}
