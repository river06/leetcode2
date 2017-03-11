import java.util.*;
public class Solution {
    public List<Integer> getRow(int rowIndex) {
		rowIndex++;
		Integer[] retArray = new Integer[rowIndex];
		
		for( int i=1; i<=rowIndex; i++) {
			retArray[0] = 1;
			int tmpOld = 1;
			for(int j=1; j<i-1; j++ ) {
				int tmpNew = retArray[j];
				retArray[j] = retArray[j] + tmpOld;
				tmpOld = tmpNew;
			}
			retArray[i-1] = 1;
		}
		List<Integer> ret = new ArrayList<Integer>
			(Arrays.asList(retArray));
		return ret;
    }
}
