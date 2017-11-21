import java.util.*;
class RandomizedSet {
    List<Integer> numbers;
    Map<Integer, Integer> num2pos;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        numbers = new ArrayList<Integer>();
	num2pos = new HashMap<Integer, Integer>();
	rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (num2pos.containsKey(val)) {
	    return false;
	} else {
	    numbers.add(val);
	    num2pos.put(val, numbers.size()-1);
	    return true;
	}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!num2pos.containsKey(val)) {
	    return false;
	} else {
	    // needs to swap the last element with the current element
	    int pos = num2pos.get(val);
	    if (pos != numbers.size()-1) {
		int lastVal = numbers.get(numbers.size()-1);
		num2pos.put(lastVal, pos);
		numbers.set(pos, lastVal); 
	    }
	    numbers.remove(numbers.size()-1);
	    num2pos.remove(val);
	    return true;
	}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
	System.out.println("debug----" + numbers.size() + "----");
        int idx = rand.nextInt(numbers.size());
	return numbers.get(idx);
    }
}
