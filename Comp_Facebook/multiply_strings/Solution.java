class Solution {
    public String multiply(String num1, String num2) {
        int[] arr1 = getNumArr(num1);
		int[] arr2 = getNumArr(num2);

		int[] ret = new int[arr1.length + arr2.length + 1];

		for (int i=0; i<arr2.length; i++) {
			int[] multiply = getMultiply(arr1, arr2[i], i);
			ret = getAddition(ret, multiply);
		}

		// get result
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (int i=ret.length-1; i>=0; i--) {
			if (isFirst && ret[i] == 0) {
				continue;
			} else {
				isFirst = false;
				sb.append(ret[i]);
			}
		}

		if (sb.length() == 0) { sb.append(0); }

		return sb.toString();
    }

	private int[] getAddition(int[] arr1, int[] arr2) {
		int preAdd = 0;
		for (int i=0; i<arr2.length; i++) {
			int cur = arr1[i] + arr2[i] + preAdd;
			arr1[i] = cur % 10;
			preAdd = cur / 10;
		}
		arr1[arr2.length] += preAdd;
		return arr1;
	}

	private int[] getMultiply(int[] arr, int num, int idx) {
		int[] ret = new int[arr.length + 1 + idx];
		int preAdd = 0;
		for (int i=0; i<arr.length; i++) {
			int mul = arr[i] * num + preAdd;
			ret[i+idx] = mul % 10;
			preAdd = mul / 10;
		}
		ret[arr.length + idx] = preAdd;
		return ret;
	}

	private int[] getNumArr(String num) {
	
		// get the array
		int nDigit = num.length();
		int[] ret = new int[nDigit];
		for (int i=0; i<nDigit; i++) {
			ret[i] = num.charAt(nDigit-1-i) - '0';
		}
		return ret;	
	}
}
