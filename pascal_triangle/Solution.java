import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

		for(int i=1; i<=numRows; i++) {
			if(i==1) {
				List<Integer> cur = new ArrayList<Integer>();
				cur.add(1);
				ret.add(cur);
			} else {
				List<Integer> pre = ret.get(i-2);
				List<Integer> cur = new ArrayList<Integer>();
				cur.add(1);
				for( int j=0; j<pre.size()-1; j++) {
					cur.add( pre.get(j)+pre.get(j+1) );
				}
				cur.add(1);
				ret.add(cur);
			}
		}

		return ret;
    }
}
