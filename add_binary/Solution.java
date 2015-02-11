public class Solution {
    public String addBinary(String a, String b) {
        if(a.length()==0) return b;
		if(b.length()==0) return a;
		
		StringBuilder sb = new StringBuilder();
		int pa = a.length()-1;
		int pb = b.length()-1;
		int carry_over = 0;
		while( pa>=0 || pb>=0) {
			int digit_a = 0;
			if( pa>=0) digit_a = a.charAt(pa)-'0';
			int digit_b = 0;
			if( pb>=0) digit_b = b.charAt(pb)-'0';
			
			int digit_sum = (digit_a + digit_b + carry_over) % 2;
			carry_over = (digit_a + digit_b + carry_over )/2;
			sb.insert(0, digit_sum);
			pa--;
			pb--;
		}
		
		// last bit
		if( carry_over == 1) sb.insert(0, 1);
		return sb.toString();
			
    }
}