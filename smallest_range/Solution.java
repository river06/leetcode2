import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ret = new int[2];
		if (nums == null || nums.size() == 0) {
			return ret;
		}
		
		Queue<ListNum> queue = new PriorityQueue<ListNum>();
		int r = Integer.MIN_VALUE;
		// initialize queue
		for (int group=0; group < nums.size(); group++) {
			if (nums.get(group).size() > 0) {
				ListNum listNum = new ListNum(nums.get(group).get(0), group, 0);
				r = Math.max(r, listNum.val);
				queue.offer(listNum);
			}
		}
		ret[0] = queue.peek().val;
		ret[1] = r;
		// get result
		while (!queue.isEmpty()) {
			ListNum prevNum = queue.poll();
			int prevGroup = prevNum.group;
			int prevIdx = prevNum.idx;
			if (prevIdx + 1 >= nums.get(prevGroup).size()) {
				break;
			}
			ListNum nextNum = new ListNum(nums.get(prevGroup).get(prevIdx+1),
										  prevGroup, prevIdx+1);
			queue.offer(nextNum);
			
			int l = queue.peek().val;
			r = Math.max(r, nextNum.val);

			// update result
			if (r - l < ret[1] - ret[0]) {
				ret[0] = l;
				ret[1] = r;
			}
		}

		return ret;
    }
	
	class ListNum implements Comparable<ListNum> {
		int val;
		int group;
		int idx;
		ListNum (int val, int group, int idx) {
			this.val = val;
			this.group = group;
			this.idx = idx;
		}

		public int compareTo (ListNum listNum) {
			return this.val - listNum.val;
		}
	}
}
