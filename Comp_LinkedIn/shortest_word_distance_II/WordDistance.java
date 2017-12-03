import java.util.*;
class WordDistance {

    /* properties */
    Map<String, List<Integer>> word2Index = null;
    
    public WordDistance(String[] words) {
        word2Index = new HashMap<String, List<Integer>>();
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            if (!word2Index.containsKey(word)) {
                word2Index.put(word, new ArrayList<Integer>());
            }
            word2Index.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = word2Index.get(word1);
        List<Integer> list2 = word2Index.get(word2);
        int minDist = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = 0;
        
        while (idx1 < list1.size() && idx2 < list2.size()) {
            int p1 = list1.get(idx1);
			int p2 = list2.get(idx2);
			if (p1 < p2) {
                minDist = Math.min(minDist, p2-p1);
                idx1++;
            } else {
                minDist = Math.min(minDist, p1-p2);
                idx2++;
            }
        }
        return minDist;
    }
}
