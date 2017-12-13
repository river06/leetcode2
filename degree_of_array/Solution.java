import java.util.*;
class Solution {
    public int findShortestSubArray(int[] nums) {
		int degree = 0;
        int length = Integer.MAX_VALUE;
		Map<Integer, PosInfo> num2PosInfo = new HashMap<Integer, PosInfo>();
		
		for (int i=0; i<nums.length; i++) {
			int num = nums[i];
			if (!num2PosInfo.containsKey(num)) {
				num2PosInfo.put(num, new PosInfo(i, i));
			}

			PosInfo posInfo = num2PosInfo.get(num);
			posInfo.degree++;
			posInfo.end = i;

			if (posInfo.degree > degree ||
				(posInfo.degree == degree &&
				 posInfo.end - posInfo.start + 1 < length)) {
				degree = posInfo.degree;
				length = posInfo.end - posInfo.start + 1;
			}
		}

		return length;
    }

	class PosInfo {
		int degree = 0;
		int start;
		int end;
		PosInfo (int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
