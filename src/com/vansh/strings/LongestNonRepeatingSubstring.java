package com.vansh.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstring {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringAlternate("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int toReturn = 0;
		Set<Character> seenChars = new HashSet<>();
		int leftIndex = 0;
		int rightIndex = 0;
		while (rightIndex < s.length() && leftIndex <= rightIndex) {
			while (rightIndex < s.length() && !seenChars.contains(s.charAt(rightIndex))) {
				seenChars.add(s.charAt(rightIndex));
				rightIndex++;
			}
			toReturn = Math.max(toReturn, rightIndex - leftIndex);
			while (leftIndex < s.length() && rightIndex < s.length() && leftIndex <= rightIndex
					&& s.charAt(leftIndex) != s.charAt(rightIndex)) {
				seenChars.remove(s.charAt(leftIndex));
				leftIndex++;
			}
			if (leftIndex < s.length()) {
				seenChars.remove(s.charAt(leftIndex));
				leftIndex++;
			}

		}
		return toReturn;
	}

	public static int lengthOfLongestSubstringAlternate(String s) {
		int toReturn = 0;
		Set<Character> seenChars = new HashSet<>();
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < s.length() && rightIndex < s.length()) {
			if (!seenChars.contains(s.charAt(rightIndex))) {
				seenChars.add(s.charAt(rightIndex++));
				toReturn = Math.max(toReturn, rightIndex - leftIndex);	
			} else {
				seenChars.remove(s.charAt(leftIndex++));
			}
		}
		return toReturn;

	}

}
