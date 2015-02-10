public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head = solver.reverseKGroup(head, 1);

		ListNode p = head;
		while(p!=null) {
			System.out.print(p.val);
			System.out.print(" ");
			p = p.next;
		}
		System.out.println(" ");
	}
}