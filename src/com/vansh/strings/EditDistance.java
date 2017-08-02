package com.vansh.strings;

public class EditDistance {
	public static boolean isOneEditAway(String one, String two) {
		if (Math.abs(one.length() - two.length()) > 1) {
			return false;
		}
		if (one.length() == two.length()) {
			return isOneMismatchAway(one, two);
		} else {
			String shorter = one.length() < two.length() ? one : two;
			String longer = one.length() < two.length() ? two : one;
			return isOneInsertAway(shorter, longer);
		}
	}

	private static boolean isOneInsertAway(String shorter, String longer) {
		int index1 = 0, index2 = 0;
		while (index1 < shorter.length() && index2 < longer.length()) {
			if (shorter.charAt(index1) != longer.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	private static boolean isOneMismatchAway(String one, String two) {
		boolean foundDiff = false;
		for (int i = 0; i < one.length(); ++i) {
			if (one.charAt(i) != two.charAt(i)) {
				if (foundDiff) {
					return false;
				}
				foundDiff = true;
			}
		}
		return true;
	}
}
