import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] numbers = {2,7,11,15};
		int target = 9;
		
		int[] ret = solver.twoSum(numbers, target);
		
		for(int num:ret) {
			System.out.println(num);
		}
	}
}
