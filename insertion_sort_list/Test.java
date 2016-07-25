import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
        ListNode head = new ListNode(1);
        //head.next = new ListNode(0);
        
        ListNode pH = solver.insertionSortList(head);
        while(pH!=null) {
            System.out.print(pH.val);
            System.out.print("->");
            pH = pH.next;
        }
        System.out.println(" ");
	}
}
