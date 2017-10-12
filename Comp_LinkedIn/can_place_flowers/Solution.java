class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean isInternal = false;
		int numZero = 0;
		int numSpot = 0;

		for (int i=0; i<flowerbed.length; i++) {
			if (flowerbed[i] == 1) {
				numSpot += isInternal ? (numZero-1)/2 : numZero/2;
				isInternal = true;
				numZero = 0;
			} else {
				numZero++;
			}
		}
		numSpot += isInternal ? numZero/2 : (numZero+1)/2;
		return numSpot >= n;
    }
}
