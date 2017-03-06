/**
 * Quick sort algorithm
 */
public class Solution {

	public ListNode sortList(ListNode head) {
        // base case
		if( head==null || head.next==null ) { return head; }
		
        // devide
		ListNode mid = findMiddle( head );
		ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
		while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = head;
            } else {
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }
		
		leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        return concat(left, middleDummy.next, right);
    }
	private ListNode findMedian(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0), tail = dummy;
        
        tail.next = left; tail = getTail(tail);
        tail.next = middle; tail = getTail(tail);
        tail.next = right; tail = getTail(tail);
        return dummy.next;
    }
    
    private ListNode getTail(ListNode head) {
        if (head == null) {
           return null;
        } 
       
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
    public ListNode sortList2(ListNode head) {
        // base case
		if( head==null || head.next==null ) { return head; }
		
        // devide
		ListNode tail = findTail( head );
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pST = dummyHead; // tail of small nodes
		while( head != tail ) {
			if( head.val < tail.val ) {
				swapVal( pST.next, head );
				pST = pST.next;
			}
			head = head.next;
		}
		swapVal(pST.next, tail);

		// break the list
		ListNode mid = pST.next;
		pST.next = null;

		// sort left
		head = sortList( dummyHead.next );

        // sort right
		mid.next = sortList( mid.next );
		
		// connect
		if( head == null ) {
			head = mid;
		} else {
			tail = findTail( head );
			tail.next = mid;
		}

		return head;
    }

	private void swapVal( ListNode p1, ListNode p2 ) {
		int tmp = p1.val;
		p1.val = p2.val;
		p2.val = tmp;
	}

	private ListNode findTail( ListNode head ) {
		ListNode tail=head;
		if( head==null ) { return tail; }
		while(tail.next!=null) { tail = tail.next; }
		return tail;
	}
}
