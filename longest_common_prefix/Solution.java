class Solution {
    public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
        int maxLength = strs[0].length();
		for (int i=1; i<strs.length; i++) {
			maxLength = getMaxLength(strs[0], strs[i], maxLength);
		}
		return strs[0].substring(0, maxLength);
    }

	int getMaxLength(String s1, String s2, int maxLength) {
		int i=0;
		for (i=0; i<Math.min(maxLength, s2.length()); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			}
		}
		return i;
	}
}
