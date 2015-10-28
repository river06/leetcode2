import java.util.*;
public class Solution {
    public String countAndSay(int n) {
        String str = "1";
		for(int i=1; i<n; i++){
			str = helper(str);

		}
		return str;
    }

	String helper(String str){
		int str_length = str.length();
		char char_cur = str.charAt(0);
		int n_char = 0;
		String ret = new String();
		for(int i=0; i<str_length; i++) {
			if(str.charAt(i)==char_cur) {
				n_char++;
			}else{
				ret += n_char;
				ret += char_cur;
				n_char = 1;
				char_cur = str.charAt(i);
			}
		}

		ret+=n_char;
		ret+=char_cur;

		return ret;
	}
}
