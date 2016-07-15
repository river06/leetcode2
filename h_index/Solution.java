public class Solution {
    public int hIndex(int[] citations) {
        // use an extra data structure to store the number of papers by citation
		int n_paper = citations.length;
		int[] papers = new int[n_paper+1];
		for(int i=0; i<n_paper; i++) {
			int n_citation = citations[i];
			n_citation = n_citation > n_paper? n_paper : n_citation;
			papers[n_citation]++;
		}
		int total_citation = 0;
		int i = 0;
		for(i=n_paper; i>=0; i--) {
			total_citation += papers[i];
			if(total_citation >= i) break;
		}
		return i;
    }
}
