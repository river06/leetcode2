import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> ret = new LinkedList<Integer>();

		// find insert position
		int idx = Arrays.binarySearch(arr, x);
		if (idx < 0) {
			idx = -(idx+1);
		}

		int numAdded = 0;
		int l = idx-1;
		int r = idx;
		while (numAdded < k) {
			// base case
			if (l<0) {
				for (int i=0; i<(k-numAdded); i++) {
					ret.add(arr[r+i]);
				}
				break;
			} else if (r >= arr.length) {
				for (int i=0; i<(k-numAdded); i++) {
					ret.addFirst(arr[l-i]);
				}
				break;
			} else {
				int lVal = arr[l];
				int rVal = arr[r];
				if (x-lVal <= rVal-x) {
					ret.addFirst(lVal);
					l--;
				} else {
					ret.add(rVal);
					r++;
				}
				numAdded++;
			}
		}

		return ret;
		
    }
}
