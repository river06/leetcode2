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

public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // quick select algorithm
		k = Math.min(k, points.length);
		partialQuickSort(0, points.length-1, points, origin, k);
		return Arrays.copyOf(points, k);
    }

	private void partialQuickSort(int l, int r, Point[] points, Point origin, int k) {
		if (l >= r) { return; }
        // quick select
		int ll = l;
		int rr = r-1;
		int jj = l;
		Point pp = points[r];
		while (ll <= rr) {
			if ( comparePoints(points[jj], pp, origin) < 0 ) {
				ll++;
				jj++;
			} else {
				Point tmp = points[jj];
				points[jj] = points[rr];
				points[rr] = tmp;
				rr--;
			}
		}
		Point tmp = points[jj];
		points[jj] = points[r];
		points[r] = tmp;
		partialQuickSort(l, jj-1, points, origin, k);
		if (jj+1 < k) {
			partialQuickSort(jj+1, r, points, origin, k);
		}
	}

	private int comparePoints(Point p1, Point p2, Point origin) {
		int d1 = (p1.x - origin.x) * (p1.x - origin.x) +
			(p1.y - origin.y) * (p1.y - origin.y);
		int d2 = (p2.x - origin.x) * (p2.x - origin.x) +
			(p2.y - origin.y) * (p2.y - origin.y);
		if (d1 < d2) {
			return -1;
		} else if (d1 > d2) {
			return 1;
		} else {
			if (p1.x < p2.x) {
				return -1;
			} else if (p1.x > p2.x) {
				return 1;
			} else {
				return p1.y-p2.y;
			}
		}
	}
}
