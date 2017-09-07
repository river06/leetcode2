import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // This is the merge sort algorithm
		// Can also be solved by building binary tree
		// Binary indexed tree, Segment tree

		List<Integer> result = new LinkedList<Integer>();
		// we use an index array to keep track of the number
		int[] indices = new int[nums.length];
		for (int i=0; i<nums.length; i++) {
			indices[i] = i;
		}

		// we use an array to store the result temporarily
		int[] count = new int[nums.length]; // initialized to zeros

		mergeSort(indices, 0, nums.length-1, nums, count);

		for (int ret: count) {
			result.add(ret);
		}
		return result;
    }

	private void mergeSort(int[] indices, int s, int e, int[] nums, int[] count) {
		// base case
		if ( s >= e ) {
			return;
		}

		// sort
		int m = (s+e)/2;
		mergeSort(indices, s, m, nums, count);
		mergeSort(indices, m+1, e, nums, count);

		// merge
		mergeMerge(indices, s, m, e, nums, count);
	}

	private void mergeMerge(int[] indices, int s, int m, int e, int[] nums, int[] count) {
		int[] newIndices = new int[e-s+1];
		int p1 = s;
		int p2 = m+1;

		int smallNumRight = 0;
		int pn = 0;
		while ( p1 <= m && p2 <= e ) {
			if ( nums[ indices[p1] ] > nums[ indices[p2] ] ) {
				newIndices[pn] = indices[p2];
				smallNumRight++;
				p2++;
			} else {
				newIndices[pn] = indices[p1];
				count[ indices[p1] ] += smallNumRight;
				p1++;
			}
			pn++;
		}

		while (p1 <= m) {
			newIndices[pn] = indices[p1];
			count[ indices[p1] ] += smallNumRight;
			pn++;
			p1++;
		}

		while (p2 <= e) {
			newIndices[pn] = indices[p2];
			pn++;
			p2++;
		}

		// copy back from new indices
		for (int i=0; i<newIndices.length; i++) {
			indices[s+i] = newIndices[i];
		}
	}
			
}
