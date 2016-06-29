import java.util.*;

public class Solution {
    public List<String> addOperators(String num, int target) {
        LinkedList<String> ret = new LinkedList<String>(); // result
        if(num.length() == 0) {
            return ret;
        }
        char[] digits = num.toCharArray(); // use char array to save time
        char[] tmpRes = new char[num.length()*2+1]; // save temperary result
        long curNum = 0;
        // first iteration add digits to avoid '+123' case
        for(int i=0; i<num.length(); i++){
            curNum = curNum*10 + digits[i]-'0';
            tmpRes[i] = digits[i];
            DFS(ret, target, 0, curNum, i+1, i+1, digits, tmpRes);
            if(digits[0]=='0') break;
        }
        return ret;
    }
    
    private void DFS(List<String>ret, int target, long curRes, long preNum, int idx, int tmpLength, char[] digits, char[] tmpRes){
        // curRes is the number separated by '+' or '-'
        // preNum is the number to be added
        
        // base case
        if(idx == digits.length){
            if(curRes + preNum ==  target){
                ret.add(new String(tmpRes, 0, tmpLength));
                return;
            }
        }
        
        long curNum = 0;
        int preLength = tmpLength;
        tmpLength++; // for operants
        
        // depth first search
        for(int i=idx; i<digits.length; i++){
            curNum = curNum*10 + digits[i]-'0'; // get current number
            
            tmpRes[tmpLength] = digits[i];
            tmpLength ++;
            
            // case '+'
            tmpRes[preLength] = '+';
            DFS(ret, target, curRes + preNum, curNum, i+1, tmpLength, digits, tmpRes);
            // case '-'
            tmpRes[preLength] = '-';
            DFS(ret, target, curRes + preNum, -curNum, i+1, tmpLength, digits, tmpRes);
            // case '*'
            tmpRes[preLength] = '*';
            DFS(ret, target, curRes, preNum*curNum, i+1, tmpLength, digits, tmpRes);
            
            // special case related to '000x'
            if(digits[idx]=='0'){
                break;
            }
        }
    }
}