package com.vansh.arrays;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch s = new BinarySearch();
		System.out.println(s.search(new int[] { 3, 1 }, 1));
	}

	/**
	 * 
	 * Search in a rotated sorted array
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		return searchRotatedHelper(nums, 0, nums.length - 1, target);
	}

	private int searchRotatedHelper(int[] nums, int low, int high, int target) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[low] <= nums[mid]) {
			// check if this part is sorted
			if (nums[low] <= target && target < nums[mid]) {
				return searchRotatedHelper(nums, low, mid - 1, target);
			} else {
				return searchRotatedHelper(nums, mid + 1, high, target);
			}
		} else {
			if (nums[mid] < target && target <= nums[high]) {
				return searchRotatedHelper(nums, mid + 1, high, target);
			} else {
				return searchRotatedHelper(nums, low, mid - 1, target);
			}
		}
	}

	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		
		for (int i = 0; i < nums.length; ++i) {
			curSum = curSum + nums[i];
			if (curSum > maxSum) {
				maxSum = curSum;
			}
			if (curSum < 0) {
				curSum = 0;
			}
		}
		return maxSum;
	}

	// public int[] searchRange(int[] nums, int target) {
	// int[] toReturn = new int[] {-1, -1};
	// int startPos = binarySearchFloorCeil(nums, 0, nums.length -1, target, true);
	// }
	//
	//
	// private int binarySearchFloorCeil(int[] nums, int low, int high, int target,
	// boolean isFloor) {
	// if (low > high) {
	// if (isFloor) {
	// return low;
	// } else {
	// return high;
	// }
	// }
	// int mid = low + (high - low)/ 2;
	// if (nums[mid] == target) {
	// return mid;
	// }else if (target < nums[mid]) {
	// return binarySearchFloorCeil(nums, low, mid -1, target, isFloor);
	// }else {
	// return binarySearchFloorCeil(nums, mid+1, high, target, isFloor);
	// }
	//
	// }
	//
}
