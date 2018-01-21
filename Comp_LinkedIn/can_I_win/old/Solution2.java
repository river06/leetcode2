import java.util.*;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		// corner case
		int sum = (maxChoosableInteger + 1)*maxChoosableInteger/2;
		if (sum < desiredTotal) { return false; }
		if (desiredTotal <= 0) { return true; }

		Map<Integer, Boolean> searchedResult = new HashMap<Integer, Boolean>();
		boolean[] isChosen = new boolean[maxChoosableInteger];
		boolean ret = negaMax(isChosen, desiredTotal, searchedResult);
		return ret;
    }

	private boolean negaMax(boolean[] isChosen, int desiredTotal,
							Map<Integer, Boolean>searchedResult) {
		// base case
		int key = this.toKey(isChosen);

		if (searchedResult.containsKey(key)) {
			return searchedResult.get(key);
		}
		
		if (desiredTotal <= 0) {
			searchedResult.put(key, false);
			return false;
		}

		for (int i=0; i<isChosen.length; i++) {
			if (!isChosen[i]) {
				isChosen[i] = true;
				boolean tmp = negaMax(isChosen, desiredTotal - i - 1,
									  searchedResult);
				isChosen[i] = false;

				if (tmp == false) {
					searchedResult.put(key, true);
					return true;
				}
			}
		}

		searchedResult.put(key, false);
		return false;
	}

	private int toKey(boolean[] isChosen) {
		int ret = isChosen[0] ? 1 : 0;
		for (int i=1; i<isChosen.length; i++) {
			ret <<= 1;
			ret += isChosen[i] ? 1 : 0;
		}
		return ret;
	}
}
