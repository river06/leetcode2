import java.util.*;

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
		k = k % n;

		if (k<=0) return;
		int count = 0;
		
		for (int i=0; count < n; i++) {
			int curIdx = i;
			int curVal = nums[i];
			do {
				int nextIdx =  (curIdx+k)%n;
				int nextVal = nums[nextIdx];

				nums[nextIdx] = curVal;
				
				curVal = nextVal;
				curIdx = nextIdx;
				count++;
			} while (curIdx != i);
		}
    }
}
