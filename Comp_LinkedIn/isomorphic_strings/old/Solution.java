import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) { return false; }

		if (s.length() != t.length()) { return false; }
		HashMap<Character,Integer> sm = new HashMap<Character, Integer>();
		HashMap<Character,Integer> tm = new HashMap<Character, Integer>();
		for (int i=0; i<s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (sm.containsKey(sc) && tm.containsKey(tc)) {
				if (sm.get(sc) != tm.get(tc)) {
					return false;
				}
			}else if ( (sm.containsKey(sc) && !tm.containsKey(tc)) ||
					   (!sm.containsKey(sc) && tm.containsKey(tc)) ) {
				return false;
			} else {
				sm.put(sc, i);
				tm.put(tc, i);
			}
		}
		return true;		
    }
}
