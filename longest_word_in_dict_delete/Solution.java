import java.util.*;
class Solution {
    public String findLongestWord(String s, List<String> d) {
		String ret = "";
        for (String str: d) {
			if (this.isSubstr(s, str)) {
				if (str.length() > ret.length() ||
					(str.length()==ret.length() && str.compareTo(ret) < 0)) {
					ret = str;
				}
			}
		}
		return ret;
    }

	private boolean isSubstr(String s, String str) {
		int p1 = 0;
		int p2 = 0;
		while (p1<s.length() && p2<str.length()) {
			if (s.charAt(p1) == str.charAt(p2)) {
				p2++;
			}
			p1++;
		}
		return p2>=str.length();
	}
				
}
