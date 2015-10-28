import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.random = head.next;
		head.next.random = head;

		RandomListNode ret = solver.copyRandomList(head);

		RandomListNode p = head;
		while(p!=null){
			System.out.println(p.label);
			p=p.next;
		}
		p = ret;
		while(p!=null){
			System.out.println(p.label);
			p=p.next;
		}
	}
}
