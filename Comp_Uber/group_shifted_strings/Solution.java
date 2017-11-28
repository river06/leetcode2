import java.util.*;
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> group = new HashMap<String, List<String>>();
		List<List<String>> ret = new LinkedList<List<String>>();
		for (String str: strings) {
			String shiftedStr = shiftString(str);
			if (!group.containsKey(shiftedStr)) {
				group.put(shiftedStr, new LinkedList<String>());
			}
			group.get(shiftedStr).add(str);
		}

		for (Map.Entry<String, List<String>> entry: group.entrySet()) {
			ret.add(entry.getValue());
		}

		return ret;
    }

	private String shiftString(String str) {
		StringBuilder sb = new StringBuilder();
		int dist = str.charAt(0) - 'a';
		for (int i=0; i<str.length(); i++) {
			char c = (char) (str.charAt(i) - dist);
			if (c < 'a') {
				c += 26;
			}
			sb.append(c);
		}

		return sb.toString();
	}
}
