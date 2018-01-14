public class Solution {
    public int numDecodings(String s) {
        // recursion is too slow, use DP

		if(s==null || s.length()==0) return 0;
		
		
		int[] num_dec = new int[s.length()+1];
		num_dec[0] = 1;

		char c1 = s.charAt(0);
		if('1'<=c1 && c1<='9') num_dec[1] = 1;

		for(int i=1; i<s.length(); i++) {
			c1 = s.charAt(i);
			char c0 = s.charAt(i-1);
			if( '1'<= c1 && c1<='9') num_dec[i+1]+=num_dec[i];
			int tmp = (c0-48)*10 + c1-48;
			if( 1<=tmp && tmp <=26 &&
				'1'<= c0 && c0<='9') num_dec[i+1]+=num_dec[i-1];
		}
		return num_dec[s.length()];

    }
}
