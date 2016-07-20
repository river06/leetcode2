import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
		if(n==0) return 0;
		if(n==1) return nums[0];

		int[] max_rob = new int[n];

		max_rob[0] = nums[0];
		max_rob[1] = Math.max( nums[0], nums[1] );
		for(int i=2; i<n; i++) {
			max_rob[i] = Math.max(max_rob[i-1], max_rob[i-2] + nums[i] );
		}
		return max_rob[n-1];
    }
}
