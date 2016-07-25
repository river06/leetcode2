/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        
        ListNode pOri = head;
        
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        
        while( pOri!= null) {
            ListNode pNew = dummyHead;
            while(pNew.next != null) {
                if( pNew.val <= pOri.val && pNew.next.val >= pOri.val) {
                    ListNode tmp = pNew.next;
                    pNew.next = new ListNode(pOri.val);
                    pNew.next.next = tmp;
                    break;
                } else {
                    pNew = pNew.next;
                }
            }
            if(pNew.next == null) {
                pNew.next = new ListNode(pOri.val);
            }
            pOri = pOri.next;
        }
        return dummyHead.next;
    }
}