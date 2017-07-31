package com.vansh.strings;

public class ZigZagConversion {
	public static void main(String[] args) {
		System.out.println(convert("ABCD", 3));
	}
	public static String convert(String s, int numRows) {
		char [] charS = s.toCharArray();
		StringBuffer[] sbArray = new StringBuffer[numRows];
		for (int i = 0 ; i < sbArray.length; ++i) {
			sbArray[i] = new StringBuffer();
		}
		int index = 0; int dir = 1;
		for (char each : charS) {
			if (index == numRows-1) {
				dir = -1;
			}
			if (index == 0) {
				dir = 1;
			}
			sbArray[index].append(each);
			index = index + dir;
		}
		return String.join("", sbArray);
	}
}
