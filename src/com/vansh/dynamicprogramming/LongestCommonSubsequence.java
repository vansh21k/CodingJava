package com.vansh.dynamicprogramming;

public class LongestCommonSubsequence {
	public static int longestCommongSubsequence(String one, String two) {
		char[] charOne = one.toCharArray();
		char[] charTwo = two.toCharArray();

		int m = charOne.length;
		int n = charTwo.length;

		int[][] matrix = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else {
					if (charOne[i - 1] == charTwo[j - 1]) {
						matrix[i][j] = 1 + matrix[i - 1][j - 1];
					} else {
						matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
					}
				}
			}
		}
		return matrix[m][n];
	}
}
