import java.util.*;
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>> ();
		if(num == null || num.length < 3) return ret;

		// two pointers algorithm.
		// one pointer is placed at the beginning, the other pointer is placed at the end
	   
		Arrays.sort(num);

		for(int p1 = 0; p1<num.length; p1++) {
			int p2 = p1+1;
			int p3 = num.length-1;

			while( p2<p3 ) {
				int compare = num[p1] + num[p2] + num[p3];
				if( compare ==0 ) {
					List<Integer> new_ret = new ArrayList<Integer>();
					new_ret.add(num[p1]);
					new_ret.add(num[p2]);
					new_ret.add(num[p3]);
					ret.add(new_ret);
					p2++;
					p3--;

					if( p2 > 0 ) {
						while( num[p2] == num[p2-1] && p2 < p3 ) p2++;
					}
					if( p3 < num.length-1 ) {
						while( num[p3] == num[p3+1] && p3 > p2) p3--;
					}
				} else if ( compare > 0 ) {
					p3--;
				} else {
					p2++;
				}
				
			}

			while( p1<num.length-1 && num[p1] == num[p1+1] ) {
				p1++;
			}
		}
		return ret;
    }
}