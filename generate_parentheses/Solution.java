import java.util.*;
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<String>();
        if(n<=0) return ret;
        helper(ret, new String(), n, n);
        return ret;
    }
    
    private void helper(List<String> ret, String cur, int l_left, int r_left) {
        // base case
        if(r_left == 0) ret.add( new String(cur));
            
        //
        if(l_left > 0) helper(ret, cur+"(", l_left-1, r_left);
            
        if(l_left < r_left) helper(ret, cur+")", l_left, r_left-1);
    }
}