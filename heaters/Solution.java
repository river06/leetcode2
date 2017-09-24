import java.util.*;
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
		Arrays.sort(heaters);

		int ret = 0;

		for(int housePos: houses) {
			int minHeaterDis;
			int heaterIdx = Arrays.binarySearch(heaters, housePos);
			if (heaterIdx >= 0) {
				minHeaterDis = 0;
			} else {
				heaterIdx = -(heaterIdx + 1);
				if (heaterIdx == heaters.length) {
					minHeaterDis = housePos - heaters[heaters.length-1];
				} else if (heaterIdx == 0) {
					minHeaterDis = heaters[0] - housePos;
				} else {
					minHeaterDis = Math.min(heaters[heaterIdx] - housePos,
						housePos - heaters[heaterIdx-1]);
				}
			}
			ret = Math.max(ret, minHeaterDis);
		}
		return ret;
    }
}
