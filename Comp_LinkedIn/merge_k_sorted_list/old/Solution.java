class Solution {
	private Comparator<ListNode> listComp = new Comparator<ListNode>() {
		public int compare(ListNode a, ListNode b) {
			return a.val - b.val;
		}
	};
	public ListNode mergeKLists(ListNode[] lists)  {
		
		if ( lists == null || lists.length == 0) { return null; }

		Queue<ListNode> heap = new PriorityQueue(lists.length, listComp);
		for (int i=0; i<lists.length; i++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			p.next = cur;
			p = p.next;

			if (cur.next != null) {
				heap.add(cur.next);
			}
		}
		return dummyHead.next;
    }
}
