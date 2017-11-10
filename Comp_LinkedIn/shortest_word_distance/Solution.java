class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1;
		int p2 = -1;
		int distance = Integer.MAX_VALUE;

		for (int i=0; i<words.length; i++) {
			String word = words[i];
			if (word.equals(word1)) {
				p1 = i;
				if (p2 != -1) {
					distance = Math.min(distance, p1 - p2);
				}
			}
			if (word.equals(word2)) {
				p2 = i;
				if (p1 != -1) {
					distance = Math.min(distance, p2 - p1);
				}
			}
		}
		return distance;
    }
}
