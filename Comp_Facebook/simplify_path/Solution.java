import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        if (path == null) {
			return "";
		}

		Deque<String> st = new LinkedList<String>();

		String[] parts = path.split("/");

		for (String part: parts) {
			if (part.equals(".") || part.equals("")) {
				continue;
			} else if (part.equals("..")) {
				if (!st.isEmpty()) {
					st.removeLast();
				}
			} else {
				st.addLast(part);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append("/");
			sb.append(st.removeFirst());
		}

		return sb.length() == 0 ? "/" : sb.toString();
    }
}
