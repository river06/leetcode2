import java.util.*;
class TwoSum {

    SortedMap<Integer, Integer> num2Occ;
        
    /** Initialize your data structure here. */
    public TwoSum() {
        num2Occ = new TreeMap<Integer, Integer>(); 
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (!num2Occ.containsKey(number)) {
            num2Occ.put(number, 1);
        } else if (num2Occ.get(number) == 1) {
            num2Occ.put(number, 2);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key: num2Occ.keySet()) {
            if (key > value / 2) {
                break;
            }
            
            if (( (value != key*2) && num2Occ.containsKey(value - key) ) || 
                ( (value == key*2) && num2Occ.get(key) == 2) ) {
                return true;
            }
        }
        
        return false;
    }
}
