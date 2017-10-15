import java.util.*;
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // corner case
		int sum = (maxChoosableInteger + 1)*maxChoosableInteger/2;
		if (sum < desiredTotal) { return false; }
		if (desiredTotal <= 0) { return true; }
		
		boolean[] used = new boolean[maxChoosableInteger+1];

		Map<String, Boolean> result = new HashMap<String, Boolean>();
		
		boolean canWin = negamax(used, desiredTotal, result);

		return canWin;
    }

	private boolean negamax(boolean[] used, int desiredTotal,
							Map<String, Boolean> result) {
		// base case
		if (desiredTotal <= 0) { return false; }

		String usedKey = Arrays.toString(used);
		if (result.containsKey(usedKey)) {
			return result.get(usedKey);
		}

		for (int i=1; i<used.length; i++) {
			if (used[i] == false) {
				used[i] = true;

				if (!negamax(used, desiredTotal-i, result)) {
					result.put(usedKey, true);
					used[i] = false;
					return true;
				} else {
					used[i] = false;
				}
			}
		}
		result.put(usedKey, false);
		return false;
	}
}
