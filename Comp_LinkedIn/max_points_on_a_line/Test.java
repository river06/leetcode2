import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] x = {-1, 1, -2};
		int[] y = {1, -1, 2};
		Point[] points = new Point[x.length];
		for (int i=0; i<x.length; i++) {
			points[i] = new Point(x[i], y[i]);
		}

		int ret = solver.maxPoints(points);

		System.out.println(ret);
	}
}
