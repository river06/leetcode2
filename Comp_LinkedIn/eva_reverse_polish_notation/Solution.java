import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) { return 0; }

		Stack<Integer> nums = new Stack<Integer>();
		for (String str: tokens) {
			if (str.equals("+") || str.equals("-") ||
				str.equals("*") || str.equals("/") ) {
				int b = nums.pop();
				int a = nums.pop();
				int c = 0;
				if (str.equals("+")) {
					c = a + b;
				} else if (str.equals("-")) { 
					c = a - b;
				} else if (str.equals("*")) {
					c = a * b;
				} else {
					c = a / b;
				}
				nums.push(c);
			} else {
				nums.push(Integer.parseInt(str));
			}
		}

		return nums.pop();
    }
}
