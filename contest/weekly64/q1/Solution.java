class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
			return -1;
		}
		int maxNum = 0;
		int maxIdx = -1;
		boolean[] isSeen = new boolean[100];

		for (int i=0; i<nums.length; i++) {
			int num = nums[i];
			if (maxNum < num) {
				maxNum = num;
				maxIdx = i;
			}
			isSeen[num] = true;
		}

		for (int i=maxNum/2+1; i<maxNum; i++) {
			if (isSeen[i]) {
				return -1;
			}
		}

		return maxIdx;
    }
}
