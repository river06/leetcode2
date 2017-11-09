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
    public int depthSum(List<NestedInteger> nestedList) {
		// BFS search using queue
		int ret = 0;
		Queue<NestedInteger> q = new LinkedList<NestedInteger>();
		for (NestedInteger curInt: nestedList) {
			q.offer(curInt);
		}
		int depth = 0;
		while (!q.isEmpty()) {
			depth++;
			int length = q.size();
			for (int i=0; i<length; i++) {
				NestedInteger curInt = q.poll();
				if (curInt == null) { continue; }
				if (curInt.isInteger()) {
					ret += curInt.getInteger() * depth;
				} else {
					for (NestedInteger nextInt: curInt.getList()) {
						q.offer(nextInt);
					}
				}
			}
		}
		return ret;
    }
}
