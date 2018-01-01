import java.util.*;
class Solution {
    public int findRotateSteps(String ring, String key) {
        // construct a map from character to their positions
		Map<Character, List<Integer>> char2Pos =
			new HashMap<Character, List<Integer>>();
		int n = ring.length();
		for (int i=0; i<n; i++) {
			char c = ring.charAt(i);
			if (!char2Pos.containsKey(c)) {
				char2Pos.put(c, new LinkedList<Integer>());
			}
			char2Pos.get(c).add(i);
		}

		// loop over the key to find the shortest path
		int[] prevStep = {0};
		List<Integer> prevPos = new LinkedList<Integer>();
		prevPos.add(0);

		for (int i=0; i<key.length(); i++) {
			char c = key.charAt(i);
			List<Integer> currPos = char2Pos.get(c);
			int[] currStep = new int[currPos.size()];

			// find the shortest path for each current position
			for (int j=0; j<currStep.length; j++) {
				int currIdx = currPos.get(j);
				int minStep = Integer.MAX_VALUE;
				for (int k=0; k<prevPos.size(); k++) {
					int prevIdx = prevPos.get(k);
					int step = Math.min( Math.abs(currIdx - prevIdx),
										 n - Math.abs(currIdx - prevIdx));
					step += prevStep[k];
					
					minStep = Math.min(minStep, step);
				}

				currStep[j] = minStep;
			}
			prevStep = currStep;
			prevPos = currPos;
		}

		int ret = Integer.MAX_VALUE;
		for (int i=0; i<prevStep.length; i++) {
			ret = Math.min(ret, prevStep[i]);
		}

		return ret + key.length();
    }
}
