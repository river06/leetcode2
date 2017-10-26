class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null | flowerbed.length == 0) {
			return false;
		}

		boolean isFirstOneFound = false;
		int nZero = 0;
		int nFlower = 0;
		for (int i=0; i<flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				nZero++;
			} else {
				if (!isFirstOneFound) {
					nFlower += nZero/2;
					isFirstOneFound = true;
				} else {
					nFlower += (nZero-1)/2;
				}
				nZero = 0;
			}
		}

		nFlower += nZero/2;
		return nFlower>=n;
    }
}
