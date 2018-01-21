import java.util.*;
class Solution {
    public boolean canWin(String s) {
		Map<String, Boolean> winMap = new HashMap<String, Boolean>();
		boolean ret = negaMax(s, winMap);
		
		return ret;
    }

	private boolean negaMax(String s, Map<String, Boolean> winMap) {
		if (winMap.containsKey(s)) {
			return winMap.get(s);
		}
		
		boolean canWin = false;

		for (int i=0; i<s.length()-1; i++) {
			if (s.startsWith("++", i)) {
				String t = s.substring(0, i) + "--" + s.substring(i + 2);
				canWin = !negaMax(t, winMap);
				if (canWin) { break; }
			}
		}
		winMap.put(s, canWin);
		return canWin;
	}
}
