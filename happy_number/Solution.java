import java.util.*;
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen_num = new HashSet<Integer>();
		while(true) {
			// transform integer
			int n2 = 0;
			while(n > 0) {
				n2 += (n%10)*(n%10);
				n /= 10;
			}

			if(n2 == 1) {
				return true;
			} else if (seen_num.contains(n2) ) {
				return false;
			} else {
				seen_num.add(n2);
				n = n2;
			}
		}
    }
}
