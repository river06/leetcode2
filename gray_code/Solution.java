import java.util.*;
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new LinkedList<Integer>();
        //if(n<=0) return ret;
        
        ret.add( 0);
        Stack<Integer> stack_int = new Stack<Integer>();
        for(int i=0; i<n; i++) {
            for( Integer int_str : ret) {
                stack_int.push( int_str);
            }
            while( !stack_int.isEmpty() ) {
                ret.add( stack_int.pop() + (1<<i));
            }
        }
        return ret;
    }
}