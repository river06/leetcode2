class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
		int n = s.length();
		if (n == 0) { return false; }

		boolean hasE, hasFirst, hasDot, hasDigit;
		hasE = hasFirst = hasDot = hasDigit = false;

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);

			if (c >= '0' && c <= '9') {
				hasFirst = hasDigit = true;
				continue;
			}

			switch (c) {
			case 'e':
				if (hasE || !hasDigit) { return false; }
				hasE = true;
				hasFirst = hasDigit = false;
				hasDot = true;
				break;
			case '+':
			case '-':
				if (hasFirst) { return false; }
				hasFirst = true;
				break;
			case '.':
				if (hasDot) { return false; }
				hasFirst = hasDot = true;
				break;
			default:
				return false;
			}
		}
		return hasDigit;
    }
}
