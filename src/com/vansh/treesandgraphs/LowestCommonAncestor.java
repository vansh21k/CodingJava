package com.vansh.treesandgraphs;

import com.sun.org.apache.regexp.internal.recompile;

public class LowestCommonAncestor {
	
	public static TreeNode commonAncestorAlternate(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}
	
	
	private static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		} 
		if (root == p && root == q) {
			return root;
		}
		TreeNode leftSide = commonAncestorHelper(root.left, p, q);
		if (leftSide!=null && leftSide!=p && leftSide!=q) {
			return leftSide;
		}
		
		TreeNode rightSide = commonAncestorHelper(root.right, p, q);
		if (rightSide!=null && rightSide!=p && rightSide!=q) {
			return rightSide;
		}
		if (leftSide!=null && rightSide!=null) {
			return root;
		} else if (root  == p || root == q) {
			return root;
		} else {
			if (leftSide!=null) {
				return leftSide;
			}
			return rightSide;
		}
	}


	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		}
		boolean isPOnLeft = covers(root.left, p);
		boolean isQOnLeft = covers(root.left, q);
		if (isPOnLeft!=isQOnLeft) {
			return root;
		}
		
		TreeNode childSide = isPOnLeft? root.left : root.right;
		return commonAncestor(childSide, p, q);
		
	}

	private static boolean covers(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		return covers(root.left, p) || covers(root.right, p);
	}
}
