public class Node {
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
