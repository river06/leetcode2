import java.util.*;

class TwoSum {

	Map<Integer, Integer> numbers;
	
    /** Initialize your data structure here. */
    public TwoSum() {
        this.numbers = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (numbers.containsKey(number)) {
			numbers.put(number, 2);
		} else {
			numbers.put(number, 1);
		}
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key: this.numbers.keySet()) {
			int key2 = value - key;
			if (key == key2) {
				if (numbers.get(key) > 1) {
					return true;
				}
			} else if (numbers.containsKey(key2)) {
				return true;
			}
		}
		return false;
    }
}


