import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[] houses = {1,2,3};
		int[] heaters = {2};*/
		int[] houses = {1,2,3,4};
		int[] heaters = {1,4};

		int ret = solver.findRadius(houses, heaters);

		System.out.println( ret );
	}
}
