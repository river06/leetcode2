import java.util.*;
public class Memcache {

	/*
	 * Properties
	 */
	// map tracking key and value
	Map<Integer, Integer> valueMap;
	// map tracking expiration time
	Map<Integer, Integer> timeMap;
	
    public Memcache() {
        this.valueMap = new HashMap<Integer, Integer>();
		this.timeMap = new HashMap<Integer, Integer>();
    }

    /**
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        if (valueMap.containsKey(key)) {
			if (timeMap.containsKey(key) && timeMap.get(key) < curtTime) {
				return Integer.MAX_VALUE;
			}
			return valueMap.get(key);
		} else {
			return Integer.MAX_VALUE;
		}
    }

    /**
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
		valueMap.put(key, value);

		if (ttl == 0) {
			timeMap.put(key, Integer.MAX_VALUE);
		} else {
			timeMap.put(key, curtTime + ttl -1);
		}
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
		valueMap.remove(key);
		timeMap.remove(key);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
		if (valueMap.containsKey(key)) {
			if (timeMap.containsKey(key) && timeMap.get(key) < curtTime) {
				return Integer.MAX_VALUE;
			}
			int newVal = valueMap.get(key) + delta;
			valueMap.put(key, newVal);
			return newVal;
		} else {
			return Integer.MAX_VALUE;
		}
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
 		if (valueMap.containsKey(key)) {
			if (timeMap.containsKey(key) && timeMap.get(key) < curtTime) {
				return Integer.MAX_VALUE;
			}
			int newVal = valueMap.get(key) - delta;
			valueMap.put(key, newVal);
			return newVal;
		} else {
			return Integer.MAX_VALUE;
		}
    }
}
