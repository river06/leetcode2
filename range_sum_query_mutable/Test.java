import java.util.*;
public class Test {
	public static void main(String[] args) {
		//int[] nums = {1, 3, 5};
		int[] nums = {};

		NumArray numArr = new NumArray(nums);

		System.out.println(numArr.sumRange(0, 2));
		numArr.update(1, 2);
		System.out.println(numArr.sumRange(0, 2));
	}
}
