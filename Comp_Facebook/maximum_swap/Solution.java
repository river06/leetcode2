class Solution {
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();

		int[] digit2LastIdx = new int[10];

		for (int i=0; i<arr.length; i++) {
			digit2LastIdx[arr[i] - '0'] = i;
		}

		for (int i=0; i<arr.length; i++) {
			for (int j=9; j > arr[i] - '0'; j--) {
				if (digit2LastIdx[j] > i) {
					char tmp = arr[i];
					arr[i] = arr[digit2LastIdx[j]];
					arr[digit2LastIdx[j]] = tmp;
					return Integer.parseInt(new String(arr));
				}
			}
		}

		return num;
    }
}
