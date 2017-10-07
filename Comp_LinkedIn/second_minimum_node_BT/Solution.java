class Solution {
    public int findSecondMinimumValue(TreeNode root) {
		int[] ret = new int[2];
		ret[0] = -1;
		ret[1] = -1;
		helper(root, ret);
		return ret[1];
	}

	private void helper(TreeNode root, int[] ret) {
		if (root == null) { return; }
		if (ret[1] >= 0 && root.val >= ret[1]) { return; }
		if (root.val < ret[0] || ret[0] == -1) {
			ret[1] = ret[0];
			ret[0] = root.val;
		} else if ( ( ret[0] >= 0 && root.val > ret[0] && root.val < ret[1]) || (ret[1] == -1 && root.val != ret[0] ) ) {
			ret[1] = root.val;
		}

		helper(root.left, ret);
		helper(root.right, ret);
	}
}
