import java.util.*;
class Solution {
	List<String> ret;
    public List<String> addOperators(String num, int target) {
		ret = new LinkedList<String>();
        char[] numArr = num.toCharArray();

		// divide expression by + or -
		long addend = 0;
		StringBuilder expression = new StringBuilder();
		for (int i=0; i<numArr.length; i++) {
			addend *= 10;
			addend += numArr[i] - '0';
			expression.append(numArr[i]);
			dfs(expression, 0, addend, target, numArr, i+1);
			if (numArr[0] == '0') { break; }
		}

		return ret;
    }

	private void dfs(StringBuilder expression, long summand, long addend,
					 int target, char[] numArr, int start) {
		if (start == numArr.length && summand + addend == target) {
			ret.add(expression.toString());
			return;
		}
		
		long num = 0;
		for (int i=start; i<numArr.length; i++) {
			num *= 10;
			num += numArr[i] - '0';
			dfs(new StringBuilder(expression).append('+').append(num),
				summand + addend, num, target, numArr, i+1);

			dfs(new StringBuilder(expression).append('-').append(num),
				summand + addend, -num, target, numArr, i+1);

			dfs(new StringBuilder(expression).append('*').append(num),
				summand, addend * num, target, numArr, i+1);

			if (numArr[start] == '0') { break; }
		}
	}
}
