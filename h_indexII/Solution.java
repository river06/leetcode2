public class Solution {
    public int hIndex(int[] citations) {
        int n_paper = citations.length;
		if(n_paper <=0 ) return 0;
		return helper(citations, 0, n_paper-1, n_paper);
    }
	private int helper(int[] citations, int idx1, int idx2, int n_paper) {
		// base cases
		if(idx1 == idx2) return citations[idx1]>0 ? n_paper-idx1 : 0;

		if(citations[idx1] + idx1 >= n_paper) return n_paper-idx1;

		int idxm = (idx1 + idx2)/2;
		if(citations[idxm] + idxm >= n_paper) {
			return helper(citations, idx1, idxm, n_paper);
		} else {
			return helper(citations, idxm+1, idx2, n_paper);
		}
	}
}
