class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length-1]) {
			return letters[0];
		}

		int l = 0;
		int r = letters.length-1;
		while (l + 1 < r) {
			int m = l + (r-l)/2;
			if (letters[m] <= target) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		if (letters[l] > target) {
			return letters[l];
		} else {
			return letters[r];
		}
    }
}
