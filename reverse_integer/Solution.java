import java.util.*;

class Solution {
    public int reverse(int x) {
    	if (x==Integer.MIN_VALUE) { return 0; }
        
        boolean isNegative = x < 0 ? true : false;
        if (isNegative) { x = -x; }

        int result = 0;
        while (x>0) {
        	if (result > Integer.MAX_VALUE/10) { return 0; }
        	result = result * 10 + x % 10;
        	x /= 10;
        	//if (result<=0) { return 0; }
        }

        if (isNegative) {
        	result = - result;
        }
        return result;
    }
}