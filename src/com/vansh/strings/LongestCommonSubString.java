package com.vansh.strings;

public class LongestCommonSubString {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int end = 0;
		int minLength = findMinLength(strs);
		while (end < minLength) {
			if (!allSame(strs, end, strs[0].charAt(end))) {
				break;
			}
			end++;
		}
		return (strs[0].substring(0, end));
	}

	private int findMinLength(String[] strs) {
		int min = Integer.MAX_VALUE;
		for (String each : strs) {
			min = Math.min(each.length(), min);
		}
		return min;
	}

	private boolean allSame(String[] strs, int pos, char c) {
		for (String each : strs) {
			if (each.charAt(pos)!= c) {
				return false;
			}
		}
		return true;
	}
}
