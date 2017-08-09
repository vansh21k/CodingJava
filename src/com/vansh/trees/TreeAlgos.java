package com.vansh.trees;

public class TreeAlgos {
	public static boolean isValidBST(TreeNode root) {
		return isBinarySearchTreeHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBinarySearchTreeHelper(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (!(root.val >= minValue && root.val <= maxValue)) {
			return false;
		}
		return isBinarySearchTreeHelper(root.left, minValue, root.val)
				&& isBinarySearchTreeHelper(root.right, root.val, maxValue);
	}

}
