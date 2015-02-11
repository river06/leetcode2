public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		ListNode l1 = new ListNode(2);
		ListNode p1 = l1;
		p1.next = new ListNode(4);
		p1 = p1.next;
		p1.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		ListNode p2 = l2;
		p2.next = new ListNode(6);
		p2 = p2.next;
		p2.next = new ListNode(4);
		
		ListNode ret = solver.addTwoNumbers(l1, l2);
		
		ListNode pr = ret;
		while( pr != null ){
			System.out.print(pr.val);
			System.out.print("->");
			pr = pr.next;
		}
		System.out.println(" " );
	}
}