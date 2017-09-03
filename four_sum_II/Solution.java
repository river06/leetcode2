import java.util.*;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> sum2Num = new HashMap<Integer,Integer>();
        // contruct a map from sum of elements in A and B to its occurance
		for (int a: A) {
			for (int b: B) {
				if (sum2Num.containsKey(a+b)) {
					sum2Num.put(a+b, sum2Num.get(a+b)+1);
				} else {
					sum2Num.put(a+b, 1);
				}
			}
		}
		int result = 0;
		for (int c: C) {
			for (int d: D) {
				if (sum2Num.containsKey(-(c+d))) {
					result += sum2Num.get(-(c+d));
				}
			}
		}
		return result;
    }
}
