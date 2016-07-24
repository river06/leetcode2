import java.util.*;

public class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(); // length of haystack
		int n = needle.length(); // length of needle
		if(n > m) return -1;
		if(n==0) return 0;

		// preprocess to store the length of prefix-postfix matching
		// before every position in the needle
		int[] n_match = new int[n];
		n_match[0] = 0;
		int idx1 = 0; // idx for pre-fix
		int idx2 = 1; // idx for post fix
		while(idx2 <n ){
			if(needle.charAt(idx1) == needle.charAt(idx2) ) {
				n_match[idx2] = idx1+1;
				idx1 ++;
				idx2 ++;
			} else if (idx1==0) {
				n_match[idx2] = 0;
				idx2++;
			} else {
				idx1 = n_match[idx1-1];
			}
		}

		// find the matching
		idx1 = 0; // haystack pointer
		idx2 = 0; // needle pointer
		while( idx1 <m ) {
			if(haystack.charAt(idx1) == needle.charAt(idx2)) {
				idx1++;
				idx2++;
			} else if (idx2==0) {
				idx1 ++;
			} else {
				idx2 = n_match[idx2-1];
			}
			if(idx2 == n) return idx1-n;
		}
		return -1;
    }
}

/* Note on Knuth-Morris-Pratt (KMP) algorithm:
   The time complexity is believed to be O(m+n), which equals to O(m) in my opinion, where m is the length of haystack and n is the length of needle, since n<=m, otherwise there is no match.
   IMO, when you move the pointer to the haystack by k steps (k<n), you can only move back the pointer to needle or equavillently move forward the hidden pointer to the haystack by k steps before you move the pointer to the haystack again. In addition, the pointer to the haystack always moves forward. Therefore, the complexity is at most 2m. In other words, you either move the haystack pointer or the hidden pointer foward, while keeping their distance at most n. 
   The idea is try not to move the pointer to the haystack backward. Notice that the 'hidden' pointer to haystack is before the actually pointer. 
   A key feature is that if there is a match to exam before moving the pointer to the haystack again, then the part before the pointer to the haystack in the haystack must match the beginning part of needle before the pointer to the needle. The part before the pointer to the haystack equals to the postfix of the part before the needle pointer. Now you ask them to match the prefix of the part before the needle pointer. This is why *storing the length of prefix-postfix matching before every position* in the needle helps. In addition, finding the LONGEST match corresponds to moving the hidden haystack pointer by the SHORTEST distance. This is why the KMP algorithm does not miss any matching. 
*/
