public class Solution {
	public int jump(int[] nums) {
		int step = 0; // number of step has to be made so far
		int curMax = 0; // current max index by step
		int nextMax = 0; // max index by step+1

		for( int i=0; i<nums.length; i++ ) {
			if( i>curMax ) {
				// has to spent another steps
				curMax = nextMax;
				step++;
			}
			// update max inde by next step
			nextMax = Math.max(nextMax, nums[i]+i);
		}
		return step;
	}

    public int jumpSoSo(int[] nums) {
        if( nums.length==1 ){ return 0; }

		// keep track of smallest number of steps to the index
		int[] steps = new int[nums.length];
		for(int i=0; i<steps.length; i++) {
			for(int j=1; j<=nums[i]&&j<steps.length-i; j++) {
				if(steps[i+j]==0) {
					steps[i+j] = steps[i]+1;
				} else {
					steps[i+j] = Math.min(steps[i+j], steps[i]+1);
				}
			}
		}
		return steps[steps.length-1];
    }
}

