package com.vansh.divideandconquer;

import java.util.Arrays;

import com.vansh.arrays.ArrayUtils;
import com.vansh.linkedlist.SwapPairs;

public class SortingAndSearch {
	
	
	public static int binarySearch(int[] arr, int x) {
		return binarySearchHelper(arr, 0, arr.length - 1, x);
	}

	public static void quickSort(int [] arr) {
		quickSortHelper(arr, 0, arr.length - 1);
	}
	
	private static void quickSortHelper(int[] arr, int low, int high) {
		if (low < high) {
			int p = partition(arr, low, high);
			quickSortHelper(arr, low, p- 1);
			quickSortHelper(arr, p+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		// we will take the last element as pivot
		int pivot = arr[high];
		int i = low -1; 
		for (int j = low; j < high; ++j) {
			if (arr[j] <= pivot) {
				i++;
				ArrayUtils.swap(arr, i, j);
			}
		}
		ArrayUtils.swap(arr, i+1, high);
		return i+1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 12, 11, 13, 5, 6, 7 };
		ArrayUtils.display(arr);
		System.out.println("After sorting");
		//mergeSort(arr);
		quickSort(arr);
		ArrayUtils.display(arr);
	}

	private static int binarySearchHelper(int[] arr, int low, int high, int x) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void mergeSort(int[] arr) {
		mergeSortHelper(arr, 0, arr.length - 1);
	}

	private static void mergeSortHelper(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSortHelper(arr, low, mid);
			mergeSortHelper(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		// copy over elements to the required array spaces
		int[] left = Arrays.copyOfRange(arr, low, mid + 1);
		int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);
		int leftIndex = 0;
		int rightIndex = 0;
		int mainIndex = low;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				arr[mainIndex++] = left[leftIndex++];
			} else {
				arr[mainIndex++] = right[rightIndex++];
			}
		}
		while (leftIndex < left.length && mainIndex <= high) {
			arr[mainIndex++] = left[leftIndex++];
		}
		while (rightIndex < right.length && mainIndex <= high) {
			arr[mainIndex++] = right[rightIndex++];
		}
	}

}
