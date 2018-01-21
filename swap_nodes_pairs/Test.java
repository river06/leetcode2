public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		ListNode head = new ListNode(0);
		//int[] nodes = {1,2};
		//int[] nodes = {1, 2, 3};
		int[] nodes = {1};
		ListNode p0 = head;
		for(int i=0; i<nodes.length; i++) {
			p0.next = new ListNode(nodes[i]);
			p0 = p0.next;
		}
		ListNode result = solver.swapPairs(head.next);

		ListNode p = result;
		while(p!=null) {
			System.out.print(p.val);
			System.out.print("->");
			p = p.next;
		}
		System.out.println(" ");
	}
}
