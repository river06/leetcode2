import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] nums = {{0, 30}, {5, 10}, {15, 20}};
		Interval[] intervals = new Interval[nums.length];
		for (int i=0; i<nums.length; i++) {
			intervals[i] = new Interval(nums[i][0], nums[i][1]);
		}

		int ret = solver.minMeetingRooms(intervals);

		System.out.println(ret);
	}
}
