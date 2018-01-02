import java.util.*;
public class Solution { 
    public int findIntegers(int num) {
        char[] str = Integer.toBinaryString(num).toCharArray();
        int len = str.length;
        // smallerPrefixEnding0 = num of even valid integers (binary representation ending in 0) smaller than current prefix
        // smallerPrefixEnding1 = num of odd  valid integers (binary representation ending in 1) smaller than current prefix
        int smallerPrefixEnding0 = 0, smallerPrefixEnding1 = 0;
        // if current prefix is a valid integer 
        boolean isPrefixValid = true;
        for (int i = 0; i < len; i++) {
            int tmp = smallerPrefixEnding0 + smallerPrefixEnding1;
            smallerPrefixEnding1 = smallerPrefixEnding0; 
            smallerPrefixEnding0 = tmp;
            if (isPrefixValid) { // current prefix is still valid, keep adding new candidates
                if (str[i] == '1') {
                    smallerPrefixEnding0++; // str[0...i-1] + '0' is smaller than str[0...i], ending in 0;
                    if (i > 0 && str[i - 1] == '1') { // two consecutive '1'
                        isPrefixValid = false;
                    }
                }
            }
            //System.out.println(smallerPrefixEnding0 + " " + smallerPrefixEnding1 + " " + isPrefixValid);
        }
        return smallerPrefixEnding0 + smallerPrefixEnding1 + (isPrefixValid ? 1 : 0);
    }
}
