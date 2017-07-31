package com.vansh.numbers;

public class ReverseNumber {
	public int reverse(int x) {
		int sign = (x >= 0) ? 1 : -1;
		x = sign * x;
		long toReturn = 0;
		while (x > 0) {
			toReturn = toReturn * 10 + x % 10;
			if (toReturn > Integer.MAX_VALUE || toReturn < Integer.MIN_VALUE) {
				return 0;
			}
			x /= 10;
		}
		return (int) toReturn * sign;
	}
}
