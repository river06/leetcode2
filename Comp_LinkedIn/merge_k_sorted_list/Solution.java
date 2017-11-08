/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	private Comparator<ListNode> listComp = new Comparator<ListNode>() {
		public int compare(ListNode a, ListNode b) {
			return a.val - b.val;
		}
	};
    public ListNode mergeKLists(ListNode[] lists) {
		if ( lists == null || lists.length == 0) { return null; }
		
        ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		Queue<ListNode> q = new PriorityQueue<ListNode>(lists.length, listComp);

		// add one of them to queue
		for (ListNode node: lists) {
			if (node != null) {	q.offer(node); }
		}

		while (!q.isEmpty()) {
			ListNode curNode = q.poll();
			p.next = curNode;
			if (curNode.next != null) {
				q.offer(curNode.next);
			}
			p = p.next;
		}
		return dummyHead.next;
    }
}
