import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        // the same idea with three sum

		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if( num==null || num.length < 4 ) return ret;

		Arrays.sort(num);

		for(int p1 = 0; p1<num.length; p1++) {
			for( int p2 = p1+1; p2<num.length; p2++) {
				int p3 = p2+1;
				int p4 = num.length-1;

				while( p3< p4) {
					int sum = num[p1] + num[p2] + num[p3] + num[p4];

					if( sum == target ) {
						List<Integer> one_ret = new ArrayList<Integer>();
						one_ret.add(num[p1]);
						one_ret.add(num[p2]);
						one_ret.add(num[p3]);
						one_ret.add(num[p4]);
						ret.add(one_ret);
						p3++;
						p4--;
						while(num[p3]==num[p3-1] && p3<p4) p3++;
						if(p4<num.length-1) {
							while(num[p4]==num[p4+1] && p4>p3) p4--;
						} // only now need to skip results, because only now there is solution
					} else if (sum > target) {
						p4--;
					} else {
						p3++;
					}
				}

				// skip repeated p2 values
				while(p2<num.length-1 && num[p2] == num[p2+1]) p2++;
			}
			// skip repeated p1 values
			while( p1<num.length-1 && num[p1]==num[p1+1]) p1++;
			
		}

		return ret;
    }
}