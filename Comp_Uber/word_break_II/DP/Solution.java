import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = new HashSet<String>();
		for (String word: wordDict) {
			wordSet.add( word );
		}
		Map<Integer, List<String>> path = new HashMap<Integer, List<String>>();
		List<String> emptyStrList = new LinkedList<String>();
		emptyStrList.add("");
		path.put(0, emptyStrList);
		
		for (int r=1; r<=s.length(); r++) {
			List<String> cur = new LinkedList<String>();
			for (int l=0; l<r; l++) {
				if (path.get(l).size() > 0 && wordSet.contains(s.substring(l, r))) {
					for (String prePath: path.get(l)) {
						cur.add(prePath + (prePath.equals("") ? "" : " ") + s.substring(l, r));
					}
				}
			}
			path.put(r, cur);
		}
		return path.get(s.length());
    }
}
