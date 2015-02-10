public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();

		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);

		ListNode result = solver.rotateRight(head,1);

		ListNode p=result;
		while(p!=null) {
			System.out.println(p.val);
			p=p.next;
		}
	}
}