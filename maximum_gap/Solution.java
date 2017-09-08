class Solution {
    public int maximumGap(int[] nums) {
        // bucket sort algorithm
		if (nums == null || nums.length <2) { return 0; }

		// find the maximum and minimum
		int max = nums[0];
		int min = nums[0];
		for (int i=1; i<nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}

		// the minumum Gap is (max-min)/(nums.length-1)
		int bucketSize = Math.max((max-min)/(nums.length-1), 1);

		int nBucket = (max-min)/bucketSize + 1; // add one for safety
		int[] maxInBucket = new int[nBucket];
		int[] minInBucket = new int[nBucket];
		boolean[] isBuckedUsed = new boolean[nBucket];

		// put values in buckets and update max and min vals
		for (int num: nums) {
			int idx = (num-min)/bucketSize;
			if (!isBuckedUsed[idx]) {
				isBuckedUsed[idx] = true;
				maxInBucket[idx] = num;
				minInBucket[idx] = num;
			} else {
				maxInBucket[idx] = Math.max(maxInBucket[idx], num);
				minInBucket[idx] = Math.min(minInBucket[idx], num);
			}
		}

		// loop through array to find the gap
		int maxGap = 0; // can be zero 
		int p1 = 0;
		int p2 = 1;
		while ( p2<nBucket && p1<nBucket ) {
			if ( isBuckedUsed[p2] ) {
				maxGap = Math.max(maxGap, minInBucket[p2] - maxInBucket[p1]);
				p1 = p2;
				p2 ++;
			} else {
				p2++;
			}
		}
		return maxGap;
    }

	
}
