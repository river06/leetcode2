import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();

		if (s == null || words == null || words.length == 0) {
			return ret;
		}

		int wL = words[0].length();

		if (s.length() < wL) { return ret; }

		Map<String, Integer> word2OccOri = new HashMap<String, Integer>();
		int nWordsOri = 0;
		for (String word: words) {
			word2OccOri.put(word, word2OccOri.getOrDefault(word, 0) + 1);
			nWordsOri++;
		}
		
		for (int start=0; start < wL; start++) {

			Map<String, Integer> word2Occ = new HashMap<String, Integer>(word2OccOri);
			int nWords = nWordsOri;
			
			int l = start;
			int r = start + wL; // right bound after word

			while (r <= s.length()) {
				String word = s.substring(r-wL, r);
				word2Occ.put(word, word2Occ.getOrDefault(word, 0) - 1);
				
				if (word2Occ.get(word) >= 0) {
					nWords--;
					if (nWords == 0) {
						ret.add(l);
						String firstWord = s.substring(l, l+wL);
						word2Occ.put(firstWord, word2Occ.get(firstWord) + 1);
						nWords++;
						l += wL;
					}
				} else {
					while (l + wL <= r) {
						String firstWord = s.substring(l, l+wL);
						word2Occ.put(firstWord, word2Occ.get(firstWord) + 1);
						if (word2Occ.get(firstWord) <= 0) {
							l += wL;
							break;
						} else {
							nWords++;
						}
						l += wL;
					}
				}
				r += wL;
			}
		}
		return ret;
    }
}
