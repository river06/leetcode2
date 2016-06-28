public class Solution {
    public List<String> addOperators(String num, int target) {
        LinkedList<String> ret = new List<String>(); // result
        if(num.length == 0) {
            return ret;
        }
        char[] digits = num.toCharArray(); // use char array to save time
        char[] tmpRes = new char[num.length()*2+1]; // save temperary result
        // first iteration add digits
        for(int i=0; i<num.length(); i++){
            
        }
    }
    
    private void DPS(List<String>ret, int target, long curRes, long preNum, int idx, int tmpLength, char[] digits, char[] tmpRes){
        // base case
        if(idx == digits.length){
            if(curRes + preNum ==  target){
                ret.add(new String(tmpRes, 0, tmpLength));
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
            DPS(ret, curRes + preNum, curNum, i+1, tmpLength, digits, tmpRes);
            // case '-'
            tmpRes[tmpLength] = '-';
            DPS(ret, curRes + preNum, -curNum, i+1, tmpLength, digits, tmpRes);
            // case '*'
            tmpRes[tmpLength] = '*';
            DPS(ret, curRes, preNum*curNum, i+1, tmpLength, digits, tmpRes);
            
        }
        
    }
}