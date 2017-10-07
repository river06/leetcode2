class Solution {
    public boolean judgeSquareSum(int c) {
		if (c == 0) { return true; }
		int half = c / 2;

		if (isSquare(c)) { return true; }
		
		for (int i=1; i<=half/i; i++) {
			if(isSquare(c-i*i)) {
				return true;
			}
		}
		return false;
    }

	private boolean isSquare(int n) {
		if (n == 0 || n == 1) { return true; }

		int l = 1;
		int r = n;
		while (l <= r) {
			int m = l + (r-l)/2;
			if (n/m == m) {
				if ( n == m*m ) {
					return true;
				} else if ( n > m*m ) {
					l = m+1;
				} else {
					r = m-1;
				}
			} else if (n/m > m) {
				l = m+1;
			} else {
				r = m-1;
			}
		}
		return false;
	}
			
}
