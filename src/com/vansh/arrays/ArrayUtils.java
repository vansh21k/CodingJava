package com.vansh.arrays;

public class ArrayUtils {
	public static <T> void display(T[] arr) {
		for (T each : arr) {
			System.out.println(each);
		}
	}
	
	public static  void display(int [] arr) {
		for (int  each : arr) {
			System.out.println(each);
		}
	}
	
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
  	}
}
