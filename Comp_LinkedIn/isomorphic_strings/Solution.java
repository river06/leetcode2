import java.util.*;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) { return false; }
		if (s.length() != t.length()) { return false; }
		Map<Character, Character> s2t = new HashMap<Character, Character>();
		Map<Character, Character> t2s = new HashMap<Character, Character>();
		for (int i=0; i<s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if ((s2t.containsKey(sc) && !t2s.containsKey(tc)) ||
				(!s2t.containsKey(sc) && t2s.containsKey(tc))) {
				return false;
			} else if (s2t.containsKey(sc) && t2s.containsKey(tc)) {
				if (s2t.get(sc) != tc || t2s.get(tc) != sc) {
					return false;
				}
			} else {
				s2t.put(sc, tc);
				t2s.put(tc, sc);
			}
		}

		return true;
    }
}
