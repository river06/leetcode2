/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}

		Queue<NestedInteger> q = new LinkedList<NestedInteger>();
		for (NestedInteger integer: nestedList) {
			q.offer(integer);
		}

		Stack<Integer> integers = new Stack<Integer>();
		Stack<Integer> nums = new Stack<Integer>();

		while (!q.isEmpty()) {
			int nInteger = 0;
			int qSize = q.size();
			for (int i=0; i<qSize; i++) {
				NestedInteger curInt = q.poll();
				if (curInt.isInteger()) {
					nInteger++;
					integers.push(curInt.getInteger());
				} else if (curInt.getList() != null) {
					for (NestedInteger nextInt: curInt.getList()) {
						q.offer(nextInt);
					}
				}
			}
			nums.push(nInteger);
		}
		int ret = 0;
		int depth = 1;
		while (!nums.isEmpty()) {
			int nInteger = nums.pop();
			for (int i=0; i<nInteger; i++) {
				ret += integers.pop() * depth;
			}
			depth++;
		}

		return ret;
    }
}
