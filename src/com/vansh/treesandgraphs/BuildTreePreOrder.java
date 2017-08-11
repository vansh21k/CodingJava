package com.vansh.treesandgraphs;

public class BuildTreePreOrder {

	static int preorderIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preorderIndex++]);
		if (inStart == inEnd) {
			return root;
		}

		int indexInInorder = getIndex(inorder, inStart, inEnd, root.val);
		root.left = buildTreeHelper(preorder, inorder, inStart, indexInInorder - 1);
		root.right = buildTreeHelper(preorder, inorder, indexInInorder + 1, inEnd);
		return root;
	}

	private int getIndex(int[] inorder, int inStart, int inEnd, int val) {
		int i;
		for (i = inStart; i <= inEnd; ++i) {
			if (inorder[i] == val) {
				return i;
			}
		}
		return i;
	}
}
