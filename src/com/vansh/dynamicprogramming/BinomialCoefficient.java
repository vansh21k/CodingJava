package com.vansh.dynamicprogramming;

public class BinomialCoefficient {
	
	public static void main(String[] args) {
		System.out.println(getBinomialCoefficient(5, 2));
	}
	public static int getBinomialCoefficient(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		int[] aux = new int[k+1];
		aux[0] = 1;
		for (int i = 0; i <= n; ++i) {
			for (int j = Math.min(i, k) ; j > 0; j--) {
				aux[j] = aux[j] + aux[j-1];
			}
		}
		return aux[k];
	}
}
