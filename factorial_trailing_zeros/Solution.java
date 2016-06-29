public class Solution{
    public int trailingZeroes(int n){
        // can be solved by counting the number of factors ended with digit 5
        int ret = 0;
        while(n>0) {
            n /=5;
            ret += n;
        }
        return ret;
    }
}