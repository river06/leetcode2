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
        if (points == null || points.length == 0) { return 0; }
		int ret = 0;
		for (int i=0; i<points.length; i++) {
			int nVertical = 0;
			int nSame = 0;
			int maxNotSame = 0;
			Map<String, Integer> slope2Num = new HashMap<String, Integer>();
			for (int j = i+1; j<points.length; j++) {
				if (points[j].x == points[i].x) {
					if (points[j].y == points[i].y) {
						nSame++;
					} else {
						nVertical ++;
					}
					continue;
				}

				int dx = points[j].x - points[i].x;
				int dy = points[j].y - points[i].y;

				int cd = gcd(dx, dy);
				
				String key = (dx/cd) + "," + (dy/cd);

				slope2Num.put(key, slope2Num.getOrDefault(key, 0) + 1);
				maxNotSame = Math.max(maxNotSame, slope2Num.get(key));
			}
			maxNotSame = Math.max(maxNotSame, nVertical);
			ret = Math.max(ret, maxNotSame + nSame + 1);
		}
		return ret;
    }

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
}
