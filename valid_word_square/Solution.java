class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
			return true;
		}

		int n = words.size();

		for (int i=0; i<n; i++) {
			String word = words.get(i);

			if (word.length() > n) { return false; }

			for (int j=0; j<word.length(); j++) {
				char c = word.charAt(j);
				String word2 = words.get(j);
				if (i >= word2.length() || c != word2.get(i)) {
					return false;
				}
			}
		}

		return true;
    }
}
