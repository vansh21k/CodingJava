package com.vansh.treesandgraphs;

import java.util.HashMap;

public class PathSum {
	public static int countPathsWithSum(TreeNode root, int targetSum) {
		HashMap<Integer, Integer> pathCount = new HashMap<>();
		return countPathsWithSumHelper(root, pathCount, 0, targetSum);
	}

	private static int countPathsWithSumHelper(TreeNode root, HashMap<Integer, Integer> pathCount, int runningSum,
			int targetSum) {
		if (root == null) {
			return 0;
		}
		runningSum += root.val;
		int totalPaths = pathCount.getOrDefault(runningSum - targetSum, 0);
		if (runningSum == targetSum) {
			totalPaths += 1;
		}
		if (!pathCount.containsKey(runningSum)) {
			pathCount.put(runningSum, 0);
		}
		pathCount.put(runningSum, pathCount.get(runningSum) + 1);

		totalPaths += countPathsWithSumHelper(root.left, pathCount, runningSum, targetSum);
		totalPaths += countPathsWithSumHelper(root.right, pathCount, runningSum, targetSum);

		pathCount.put(runningSum, pathCount.get(runningSum) - 1);
		return totalPaths;
	}
}
