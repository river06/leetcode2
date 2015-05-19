public class Solution {
    public int maxArea(int[] height) {
		int ret = 0;
		if(height==null || height.length ==0) return ret;

		int ll = 0;
		int rr = height.length-1;
		while( ll < rr ) {
			int cur = (rr-ll)*Math.min(height[ll], height[rr]);
			if( cur > ret) ret = cur;
			if( height[ll] <= height[rr] ) {
				ll ++;
			} else {
				rr --;
			}
		}
		return ret;
    }
}