public class Solution {
    public int titleToNumber(String s) {
		if(s==null || s.length()==0) return 0;
		int ret = 0;
		
		int s_length = s.length();
		int mul = 1;
		int base = 26;
		for(int i=s_length-1; i>=0; i--) {
			int c = s.charAt(i) - 'A' +1;
			ret += c*mul;
			mul *= base;
		}
		return ret;
    }
}
