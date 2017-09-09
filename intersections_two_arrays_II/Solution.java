import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for (int num: nums1) {
			if (!map1.containsKey(num)) {
				map1.put(num, 1);
			} else {
				map1.put(num, map1.get(num)+1);
			}
		}

		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

		for (int num: nums2) {
			if (map1.containsKey(num)) {
				if (map1.get(num) > 0) {
					if (!map2.containsKey(num)) {
						map2.put(num, 1);
					} else {
						map2.put(num, map2.get(num)+1);
					}
					map1.put(num, map1.get(num)-1);
				}
			}
		}
		int numIntersection = 0;
		for (int key: map2.keySet()) {
			numIntersection += map2.get(key);
		}

		int[] ret = new int[numIntersection];
		int idx = 0;
		for (int key: map2.keySet()) {
			copyToArr(ret, idx, key, map2.get(key));
			idx += map2.get(key);
		}

		return ret;
    }

	private void copyToArr(int[] ret, int s, int val, int length) {
		for (int p = s; p<s+length; p++) {
			ret[p] = val;
		}
	}
}
