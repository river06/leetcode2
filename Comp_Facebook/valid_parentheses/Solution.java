class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> st = new Stack<Character>();
		boolean isValid = true;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
				case '(':
			    case '{':
			    case '[':
					st.push(c);
					break;
				case ')':
					if (!st.isEmpty()) {
						if (st.pop() != '(') { isValid = false; }
					} else {
						isValid = false;
					}
					break;
				case '}':
					if (!st.isEmpty()) {
						if (st.pop() != '{') { isValid = false; }
					} else {
						isValid = false;
					}
					break;
				case ']':
					if (!st.isEmpty()) {
						if (st.pop() != '[') { isValid = false; }
					} else {
						isValid = false;
					}
					break;
				default:
					isValid = false;
			}
			if (!isValid) { break; }
		}

		return isValid && st.isEmpty();
    }
}
