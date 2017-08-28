import java.util.*;

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
		k = k % n;

		if (k<=0) return;

		int curIdx = 0;
		int curVal = nums[0];
		for (int i=0; i<n; i++) {
			int nextIdx =  (curIdx+k)%n;
			int nextVal = nums[nextIdx];

			nums[nextIdx] = curVal;

			System.out.println( Arrays.toString(nums));
			
			curVal = nextVal;
			curIdx = nextIdx;
		}
    }
}
