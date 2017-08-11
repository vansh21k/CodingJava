package com.vansh.treesandgraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> toReturn = new LinkedList<>();
		Stack<TreeNode> leftToRight = new Stack<>();
		Stack<TreeNode> rightToLeft = new Stack<>();
		if (root != null) {
			leftToRight.add(root);
		}
		while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
			LinkedList<Integer> newLevel = new LinkedList<>();
			while (!leftToRight.isEmpty()) {
				TreeNode temp = leftToRight.pop();
				newLevel.add(temp.val);
				if (temp.left != null) {
					rightToLeft.push(temp.left);
				}
				if (temp.right != null) {
					rightToLeft.push(temp.right);
				}
			}
			if (newLevel.size() > 0) {
				toReturn.add(newLevel);
			}
			newLevel = new LinkedList<>();
			while (!rightToLeft.isEmpty()) {
				TreeNode temp = rightToLeft.pop();
				newLevel.add(temp.val);
				if (temp.right != null) {
					rightToLeft.push(temp.right);
				}
				if (temp.left != null) {
					rightToLeft.push(temp.left);
				}
			}
			if (newLevel.size() > 0) {
				toReturn.add(newLevel);
			}

		}
		return toReturn;

	}
}
