import java.util.*;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int dis = Integer.MAX_VALUE;
		int ret = 0;
		if(num == null || num.length < 3) return ret;
	   
		Arrays.sort(num);

		for(int p1 = 0; p1<num.length; p1++) {
			int p2 = p1+1;
			int p3 = num.length-1;

			while( p2<p3 ) {
				int compare = num[p1] + num[p2] + num[p3] - target;

				if( Math.abs( compare ) < dis ) {
					ret = num[p1] + num[p2] + num[p3];
					dis = Math.abs(compare);
				}
				
				if( compare ==0 ) {
					return target;
					// p2++;
					// p3--;

					// if( p2 > 0 ) {
					// 	while( num[p2] == num[p2-1] && p2 < p3 ) p2++;
					// }
					// if( p3 < num.length-1 ) {
					// 	while( num[p3] == num[p3+1] && p3 > p2) p3--;
					// }
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