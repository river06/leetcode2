import java.util.*;
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
		// this problem is really unclear.
		int[] ret = new int[n];
		// we need a stack to track the previous function
		Stack<Integer> preFcn = new Stack<Integer>();
		int preStart = 0;
		// sweep one time and
		// start -> add to stack
		// end -> pop stack
		for (String log: logs) {
			int[] info = getInfo(log); 
			if (info[0] == 1) {
				if (!preFcn.isEmpty()) {
					int preFcnIdx = preFcn.peek();
					ret[preFcnIdx] += info[2] - preStart;
				}
				preFcn.push(info[1]);
			} else {
				preFcn.pop();
				ret[info[1]] += info[2] - preStart;
			}
			preStart = info[2];
		}
		return ret;
    }
    /**
     * @return int[0]: -1 end; 1 start
     *         int[1]: function id
     *         int[2]: time
     */
    private int[] getInfo(String log) {
		String[] infoStr = log.split(":");
		int[] info = new int[3];
		info[0] = infoStr[1].equals("start") ? 1 : -1;
		info[1] = Integer.parseInt(infoStr[0]);
		info[2] = Integer.parseInt(infoStr[2]);
		if (info[0] == -1) {
			info[2]++;
		}
		return info;
    }
}
