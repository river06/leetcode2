import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
		for (int num: nums1) {
			set1.add(num);
		}

		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int num: nums2) {
			if (set1.contains(num)) {
				set2.add(num);
			}
		}

		int[] ret = new int[set2.size()];
		int i = 0;
		for (int x: set2) {
			ret[i++] = x;
		}

		return ret;
		
    }
}
