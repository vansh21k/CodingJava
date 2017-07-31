package com.vansh.dynamicprogramming;

public class LongestCommonSubstring {
	public String longestPalindrome(String s) {
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		int start = 0;
		int maxlen = 1;
		for (int i = 0; i < s.length(); ++i) {
			isPalindrome[i][i] = true;
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				isPalindrome[i][i + 1] = true;
				start = i;
				maxlen = 2;
			}
		}
		for (int k = 3; k <= s.length(); ++k) {
			for (int i = 0; i < s.length() - k + 1; ++i) {
				int j = i + k - 1;
				if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					isPalindrome[i][j] = true;
					if (k > maxlen) {
						maxlen = k;
						start = i;
					}
				}
			}
		}

		String toReturn = s.substring(start, start + maxlen);
		return toReturn;
	}
}
