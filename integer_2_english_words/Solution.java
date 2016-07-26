import java.util.*;

public class Solution {
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        
        Deque<String> str_stack = new ArrayDeque<String>();
        int level = 0;
        while(num>0) {
            str_stack.push(threeDigitsToWord(num%1000));
            num /= 1000;
            level++;
        }
        
        String ret = "";
        
        while( !str_stack.isEmpty()) {
            String tmp = str_stack.pop();
            if( !tmp.isEmpty() ) {
                if( !ret.isEmpty() ) ret += " ";
                ret += tmp;
                if(level > 1) ret += (" " + numNames[level-2]);
            }
            level --;
        }
        
        return ret;
        
    }
    
    String threeDigitsToWord(int num) {
        String ret = "";
        int bai = num/100;
        if(bai > 0) {
            ret += geDigit[bai-1] + " Hundred";
        }
        int geShi = num%100;
        if( geShi>=10 && geShi<=19) {
            if(bai>0) ret += " ";
            ret += geShiDigit[ geShi%10 ];
        } else {
            int ge = geShi % 10;
            int shi = geShi/ 10;
            if(shi > 0) {
                if(bai>0) ret += " ";
                ret += shiDigit[shi -2];
            }
            if(ge > 0) {
                if(bai>0 || shi>0) ret += " ";
                ret += geDigit[ge -1];
            }
        }
        return ret;
    }
    
    private final String[] geDigit = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private final String[] shiDigit = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private final String[] geShiDigit = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] numNames = {"Thousand","Million","Billion"};
    
}