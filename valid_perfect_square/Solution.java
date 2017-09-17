class Solution {
    public boolean isPerfectSquare(int num) {
        // basically sqrt
		if (num < 0) { return false; }
		if (num == 0 || num == 1) { return true; }

		int l = 1;
		int r = num;

		while (l < r) {
			int m = (l+r)/2;

			if ( num/m > m ) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		return num == l*l;
    }
}
