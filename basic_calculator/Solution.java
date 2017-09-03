import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Character> operator = new Stack<Character>();
		Stack<Integer> number = new Stack<Integer>();
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case ' ':
				break;
			case '(':
			case '+':
			case '-':
				operator.push(c);
				break;
			case ')':
				operator.pop();
				if (!operator.isEmpty()) {
					char op = operator.peek();
					if (op == '+' || op == '-' ) {
						int num2 = number.pop();
						if (op == '-') { num2 = -num2; }
						int num1 = number.pop();
						number.push(num1 + num2);
						operator.pop();
					}
				}  
				break;		
			default:
				int num = 0;
				if (i>0 && s.charAt(i-1) >= '0' && s.charAt(i-1) <= '9') {
					num = number.pop();
					num = num*10 + c-'0';
				} else {
					num = c-'0';
				}
				
				if ((i==s.length()-1 || (s.charAt(i+1)<'0' || s.charAt(i+1)>'9'))
					&& !operator.isEmpty() ) {

					char op = operator.peek();
					if (op == '+' || op == '-') {
						int num1 = number.pop();
						if (op=='-') { num = -num; }
						num += num1;
						operator.pop();
					}
				}
				number.push(num);
			}
		}
		return number.isEmpty() ? 0 : number.peek();
    }
}
