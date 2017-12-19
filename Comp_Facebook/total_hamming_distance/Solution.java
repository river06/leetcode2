class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] freq = new int[32];

		for (int num: nums) {
			getFreq(num, freq);
		}
		int nNum = nums.length;
		int hamming = 0;
		for (int i=0; i<freq.length; i++) {
			hamming += freq[i] * (nNum - freq[i]);
		}

		return hamming;
    }

	private void getFreq(int num, int[] freq) {
		int pos = 0;

		while (num > 0) {
			if ((num & 1) == 1) {
				freq[pos]++;
			}
			pos++;
			num = num >> 1;
		}
	}
}
