import java.util.*;

public class Solution {

	// Map from computer position to computer id
	TreeMap<Integer, Integer> node2Machine;
	int n;
	int k;
	
    /**
     * @param n: a positive integer
     * @param k: a positive integer
     * @return: a Solution object
     */
    public static Solution create(int n, int k) {
        Solution solution = new Solution();
		solution.n = n;
		solution.k = k;
		solution.node2Machine = new TreeMap<Integer, Integer>();
		return solution;
    }

    /**
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
		Random rdm = new Random();
		List<Integer> rdmNodes = new ArrayList<Integer>();
		for (int i=0; i<k; i++) {
			int node = rdm.nextInt(n);
			while (node2Machine.containsKey(node)) {
				node = rdm.nextInt(n);
			}
			node2Machine.put(node, machine_id);
			rdmNodes.add(node);
		}
		return rdmNodes;
    }

    /**
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
		Integer node = node2Machine.ceilingKey(hashcode);
		if (node == null) {
			node = node2Machine.firstKey();
		}

		return node2Machine.get(node);
    }
}
