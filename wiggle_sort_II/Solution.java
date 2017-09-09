import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        if (nums==null || nums.length<2) { return; }
		int numsLength = nums.length;
		
		int medianIdx = nums.length/2; // odd or even find this median
		this.quickSelect(nums, 0, numsLength-1, medianIdx);

		// three way partition
		int medianVal = nums[medianIdx];
		int i = 0, j = 0, k = numsLength-1;
		while (j<=k) {
			if (nums[getMappedIdx(j, numsLength)] > medianVal) {
				swap(nums, getMappedIdx(i, numsLength), getMappedIdx(j, numsLength));
				i++;
				j++;
			} else if (nums[getMappedIdx(j, numsLength)] < medianVal) {
				swap(nums, getMappedIdx(j, numsLength), getMappedIdx(k, numsLength));
				k--;
			} else {
				j++;
			}
		}
		
    }
	/**
	 * Quick select algorithm to find mIdx(th) element in the array starting from sIdx to eIdx
	 * This function puts the element to be found in the mIdx index of the nums array
	 */
	private void quickSelect(int[] nums, int sIdx, int eIdx, int mIdx) {
		int rIdx = this.quickDivide(nums, sIdx, eIdx);

		if (rIdx == mIdx) {
			return;
		} else if (rIdx < mIdx) {
			this.quickSelect(nums, rIdx+1, eIdx, mIdx);
		} else {
			this.quickSelect(nums, sIdx, rIdx-1, mIdx);
		}
	}
	/**
	 * Selects a random element and return its sorted position
	 * This orders numbers backwards for simplicty of the overall solution
	 */
	private int quickDivide(int[] nums, int sIdx, int eIdx) {
		// get a random number from [sIdx, eIdx]
		Random rand = new Random();

		int rIdx = rand.nextInt(eIdx-sIdx+1) + sIdx;

		// swap it to the end
		this.swap(nums, rIdx, eIdx);
		int rValue = nums[eIdx];
		// throw small numbers to the back
		int slowIdx = sIdx;
		for (int fastIdx=sIdx; fastIdx<eIdx; fastIdx++) {
			if (nums[fastIdx] > rValue) {
				this.swap(nums, slowIdx, fastIdx);
				slowIdx++;
			}
		}
			
		// swap back
		this.swap(nums, slowIdx, eIdx);
		return slowIdx;
		
	}

	private int getMappedIdx(int oIdx, int numsLength) {
		int mappedIdx = (1+2*oIdx) % (numsLength|1);
		return mappedIdx;
	}

	private void swap(int[] nums, int p1, int p2) {
		int tmp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = tmp;
	}
		
}
