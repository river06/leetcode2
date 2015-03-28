public class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;

		int n1 = 1;
		int n2 = 2;
		int ret = 0;
		
		for(int i=3; i<=n; i++) {
			ret = n1 + n2;
			n1 = n2;
			n2 = ret;
		}
		return ret;
    }
}