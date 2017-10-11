import java.util.*;
public class Test {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		Node head = cache.dummyHead;
		printCache(head);

		int key = 1;
		int val = cache.get(key);
		System.out.println(key + "->" + val);

		cache.set(key, 1);
		printCache(head);
		val = cache.get(key);
		System.out.println(key + "->" + val);

		key = 2;
		val = 2;
		cache.set(key, val);
		printCache(head);
		val = cache.get(key);
		System.out.println(key + "->" + val);

		key = 3;
		val = 3;
		cache.set(key, val);
		printCache(head);
		val = cache.get(key);
		System.out.println(key + "->" + val);

		key = 4;
		val = cache.get(key);
		printCache(head);
		System.out.println(key + "->" + val);

		key = 1;
		val = cache.get(key);
		printCache(head);
		System.out.println(key + "->" + val);

		key = 3;
		val = 5;
		cache.set(key, val);
		printCache(head);
		val = cache.get(key);
		System.out.println(key + "->" + val);
	}

	private static void printCache(Node head) {
		Node p = head;
		while (p != null) {
			System.out.print("["+p.val+"],");
			p = p.next;
		}
		System.out.println("");
	}
}
