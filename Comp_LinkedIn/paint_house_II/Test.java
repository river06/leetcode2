import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[][] costs = {
			{14,2,11}
		};*/
		int[][] costs = {
			{19,33,30},
			{30,26,14},
			{23,32,14},
			{21,16,32},
			{16,30,30},
			{15,18,30},
			{21,21,21},
			{23,30,15},
			{19,16,5},
			{17,20,30},
			{32,12,19},
			{18,8,31},
			{29,21,10},
			{2,9,13},
			{31,30,22}
		};

		int ret = solver.minCostII(costs);

		System.out.println(ret);
	}
}
