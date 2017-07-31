package com.vansh.divideandconquer;

public class Power {
	public static double power(double x, int n ) {
		if (n == 0) {
			return 1;
		}
		double temp = power(x , n/2);
		if (n %2 == 0) {
			return temp * temp;
		}else {
			if (n  > 0) {
				return temp * temp * x;
			}else {
				return (temp * temp)/x; 
			}
		}
	}
}
