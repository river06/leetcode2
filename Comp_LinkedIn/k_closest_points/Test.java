import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		Point origin = new Point(0, 0);
		int[][] coord = {{3,3},{1,-1},{-1,1}};
		Point[] points = new Point[coord.length];
		for (int i=0; i<coord.length; i++) {
			points[i] = new Point(coord[i][0], coord[i][1]);
		}
		int k = 2;

		Point[] ret = solver.kClosest(points, origin, k);

		for (Point pt: ret) {
			System.out.println("x: " + pt.x + " y: " + pt.y);
		}
	}
}
