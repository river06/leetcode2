import java.util.*;
class Solution {
    public int maximumSwap(int num) {
        int[] digit2Pos = new int[10];
		
		// get the digits to position and the digits
		char[] numStr = Integer.toString(num).toCharArray();
		for (int i=0; i<numStr.length; i++) {
			digit2Pos[numStr[i]-'0'] = i;
		}
		
		// try to swap
		for (int i=0; i<numStr.length; i++) {
			for (int digit=9; digit > numStr[i]-'0'; digit--) {
				if (digit2Pos[digit] > i) {
					numStr[digit2Pos[digit]] = (char) (numStr[i]);
					numStr[i] = (char) (digit+'0');
					return Integer.parseInt(new String(numStr));
				}
			}
		}

		return num;
    }
}
