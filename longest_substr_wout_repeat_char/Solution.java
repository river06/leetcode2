import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) { return 0; }
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int result = 0;

		Integer p1=0;
		Integer p2=0;
		while( p2<s.length() ) {
			Character c = s.charAt(p2);
			Integer pc = map.get(c); // Integer can be null, int can not
			if (pc!=null && pc>=p1) {
				p1 = pc+1;
			}
			map.put(c, p2);
			p2++;
			if (p2-p1>result) { result = p2-p1; }
		}

		return result;
    }
}
