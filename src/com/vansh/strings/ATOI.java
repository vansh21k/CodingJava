package com.vansh.strings;

public class ATOI {

	public static void main(String[] args) {
		System.out.println(myAtoi("1"));
	}
	
	public static  int myAtoi(String str) {
		String trimmed = str.trim();
		long toReturn = 0;
		int sign = 1;
		for (int i = 0; i < trimmed.length(); ++i) {
			char current = trimmed.charAt(i);
			if (i == 0 && (current == '-' || current == '+')) {
				if (current == '-') {
					sign = -1;
				}
			} else {
				if (!Character.isDigit(current)) {
					return 0;
				}
				toReturn = toReturn * 10 + Integer.valueOf(current - '0');
				if (toReturn > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (toReturn < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
		}

		return (int)(sign * toReturn);
	}

}
