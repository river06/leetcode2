import java.util.*;
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null || triangle.size()==0) { return 0; }

		Integer[] ret = new Integer[triangle.size()];
        ret = triangle.get(triangle.size()-1).toArray(ret);

		for( int i=triangle.size()-2; i>=0; i-- ) {
			List<Integer> row = triangle.get(i);
			for( int j=0; j<=i; j++ ){
				ret[j] = Math.min(ret[j], ret[j+1]) + row.get(j);
			}
		}

		return ret[0];
    }
}
