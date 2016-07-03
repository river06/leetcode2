/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

	private int idx = 0; // lazy initiate?
	private List<Integer> flatList = new LinkedList<Integer>();

    public NestedIterator(List<NestedInteger> nestedList) {
		if(nestedList.size()==0) return;
		for(int i=0; i<nestedList.size(); i++) {
			NestedInteger curNestedInteger = nestedList.get(i);
			if( curNestedInteger.isInteger()) {
				flatList.add( curNestedInteger.getInteger() );
			} else {
				List<NestedInteger> tmpList = curNestedInteger.getList();
				Stack<NestedInteger> tmpStack = new Stack<NestedInteger>();
				for( int j=tmpList.size()-1; j>=0; j--) {
					tmpStack.push(tmpList.get(j));
				}
				while( !tmpStack.empty() ){
					NestedInteger tmpInt = tmpStack.pop();
					if( tmpInt.isInteger() ) {
						flatList.add( tmpInt.getInteger() );
					} else {
						List<NestedInteger> stackList
							= tmpInt.getList();
						for( int k=stackList.size()-1; k>=0; k--) {
							tmpStack.push(stackList.get(k));
						}
					}
				}				
			}
		}
    }

    @Override
    public Integer next() {
        return flatList.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < flatList.size() ? true : false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
