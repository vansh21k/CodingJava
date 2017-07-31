package com.vansh.numbers;

public class Divide {

	public static void main(String[] args) {
		Divide div = new Divide();
		System.out.println(div.divide(-1, -1));
	}

	public int divide(int dividend, int divisor) {
		int sign = 1;
		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
			sign = -1;			
		}
		
		if (dividend == 0 || dividend < divisor) {
			return 0;
		}
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		dividend = (dividend > 0) ? dividend : -1 * dividend;
		divisor = (divisor > 0) ? divisor : -1 * divisor;

		long lDivident = (long) dividend;
		long lDivisor = (long) divisor;
		long lAns = ldivide(lDivident, lDivisor);
		if (lAns > Integer.MAX_VALUE) {
			return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			return sign * (int) lAns;
		}

	}

	private long ldivide(long ldividend, long ldivisor) {
		if (ldividend < ldivisor) {
			return 0;
		}
		long sum = ldivisor;
		int multiple = 1;
		while (sum + sum <= ldividend) {
			sum += sum;
			multiple += multiple;
		}
		return multiple + ldivide(ldividend - sum, ldivisor);
	}
}
