class Solution {
    public int myAtoi(String str) {
        boolean isStarted = false;
        boolean isNegative = false;
        int result = 0;
        for (int i=0; i<str.length(); i++) {
        	Character c = str.charAt(i);
        	// remove white space
        	if (!isStarted) {
        		if (c == ' ') { continue; }
        		if (c == '+') { 
        			isStarted = true; 
        			continue; 
        		}
        		if (c == '-') { 
        			isStarted = true; 
        			isNegative = true; 
        			continue; 
        		}
        	}

        	// if not a number, break
        	if (c < '0' || c > '9') { break; }
        	isStarted = true;
        	// else make the conversion. Overflow case:
        	if (result > Integer.MAX_VALUE / 10) {
        		return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	}

        	result = result * 10 + (c-'0');

        	if (result < 0) {
        		return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	}
        }
        if (isNegative) { result = -result; }
        return result;
    }
}