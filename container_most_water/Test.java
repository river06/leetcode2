import java.util.Arrays;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] height =  {0, 1,0, 1,0, 1,0, 1};
		int ret = solver.maxArea(height);
		System.out.println(Arrays.toString(height));
		System.out.println(ret);
	}
}