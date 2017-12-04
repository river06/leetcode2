class Solution {
    public boolean isPalindrome(int x) {
		// special cases
		if (x < 0) { return false; }
		
        // invert half of the number to avoid overflow
		int nDigits = 0;
		int y = x;
		while (y > 0) {
			nDigits++;
			y /= 10;
		}

		y = 0;
		for (int i=0; i<nDigits/2; i++) {
			y *= 10;
			y += x % 10;
			x /= 10;
		}

		if (nDigits % 2 != 0) {
			x /= 10;
		}

		return x == y;
    }
}
