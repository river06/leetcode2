import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
        int[] gas = {6,1,4,3,5};
        int[] cost = {3,8,2,4,2};
        System.out.println( solver.canCompleteCircuit(gas, cost));
	}
}
