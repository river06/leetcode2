import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] pos = new int[n]; // pos[x] = y
		List<List<String>> ret = new LinkedList<List<String>>();
		helper(ret, pos, 0);

		return ret;
    }

	void helper(List<List<String>> ret, int[] pos, int rIdx) {
		if (rIdx == pos.length) {
			ret.add(getStringRepresentation(pos));
			return;
		}

		for (int cIdx = 0; cIdx < pos.length; cIdx++) {
			if (isValid(pos, rIdx, cIdx)) {
				pos[rIdx] = cIdx;
				helper(ret, pos, rIdx+1);
			}
		}
	}

	List<String> getStringRepresentation(int[] pos) {
		List<String> ret = new ArrayList<String>(pos.length);
		for (int i=0; i<pos.length; i++) {
			char[] row = new char[pos.length];
			Arrays.fill(row, '.');
			row[pos[i]] = 'Q';
			ret.add(String.valueOf(row));
		}
		return ret;
	}
	
	boolean isValid(int[] pos, int rIdx, int cIdx) {
		for (int i=0; i<rIdx; i++) {
			if (pos[i] == cIdx || rIdx - i == Math.abs(cIdx - pos[i])) {
				return false;
			}
		}
		return true;
	}
}
