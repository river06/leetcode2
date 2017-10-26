/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.*;

class Solution {
    public int maxPoints(Point[] points) {
        int ret = 0;
		// loop through points
		if (points == null) { return 0; }
		for (int i=0; i<points.length; i++) {
			// initialize
			int overlap = 0;
			int vertical = 0;
			int maxOnLine = 0;
			Map<String, Integer> slope2Num = new HashMap<String, Integer>();

			for (int j = i+1; j<points.length; j++) {
				// special case
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						overlap++;
					} else {
						vertical++;
					}
					continue;
				}

				int dx = points[i].x - points[j].x;
				int dy = points[i].y - points[j].y;
				int tmp = gcd(dx, dy);

				dx /= tmp;
				dy /= tmp;
				String k = dy + "/" + dx;


				slope2Num.put(k, slope2Num.getOrDefault(k, 0) + 1);

				maxOnLine = Math.max(maxOnLine, slope2Num.get(k));
			}

			maxOnLine = Math.max(maxOnLine, vertical);
			ret = Math.max(ret, maxOnLine + overlap + 1);
		}
		return ret;
    }

	int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
}
