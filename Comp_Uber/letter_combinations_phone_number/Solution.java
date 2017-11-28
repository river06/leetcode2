import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
		String[] num2Str = {
			"", "", "abc", "def", "ghi", "jkl", "mno",
			"pqrs", "tuv", "wxyz"
		};

		String firstStr = num2Str[digits.charAt(0) - '0'];
		for (int j=0; j<firstStr.length(); j++) {
			ret.add("" + firstStr.charAt(j));
		}
		
		for (int i=1; i<digits.length(); i++) {
			List<String> newRet = new LinkedList<String>();
			String curStr = num2Str[digits.charAt(i) - '0'];
			for (String preStr: ret) {
				for (int j=0; j<curStr.length(); j++) {
					newRet.add(preStr + curStr.charAt(j));
				}
			}
			ret = newRet;
		}
		return ret;	
    }
}
