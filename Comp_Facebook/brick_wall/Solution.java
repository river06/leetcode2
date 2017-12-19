class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> length2Fre = new HashMap<Integer, Integer>();
		int maxFreq = 0;
		for (List<Integer> layer: wall) {
			int curLength = 0;
			for (int i=0; i<layer.size(); i++) {
				curLength += layer.get(i);
				length2Fre.put(curLength, length2Fre.getOrDefault(curLength, 0) + 1);
				maxFreq = Math.max(maxFreq, length2Fre.get(curLength));
			}
		}

		return wall.size() - maxFreq;
    }
}
