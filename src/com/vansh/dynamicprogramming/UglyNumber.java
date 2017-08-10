package com.vansh.dynamicprogramming;

public class UglyNumber {
	public static int getNthUglyNumber(int n) {
		int[] ugly = new int[n];
		int nextMultipleTwo = 2;
		int nextMultipleThree = 3;
		int nextMultipleFive = 2;

		int uglyIndex = 1;
		int powTwoIndex = 0;
		int powThreeIndex = 0;
		int powFiveIndex = 0;

		ugly[0] = 1;
		while (uglyIndex < n) {
			ugly[uglyIndex] = Math.min(nextMultipleTwo, Math.min(nextMultipleThree, nextMultipleFive));
			if (ugly[uglyIndex] == nextMultipleTwo) {
				nextMultipleTwo = ugly[powTwoIndex++] * 2;
			}
			if (ugly[uglyIndex] == nextMultipleThree) {
				nextMultipleThree = ugly[powThreeIndex++] * 3;
			}
			if (ugly[uglyIndex] == nextMultipleFive) {
				nextMultipleFive = ugly[powFiveIndex++] * 5;
			}
		}
		return ugly[n - 1];

	}
}
