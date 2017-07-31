package com.vansh.numbers;

public class NextPermutation {
	
	public void nextPermutation(int[] nums) {
		int inversionIndex = -1;
		// if inversion index is still -1 then basically just rev up the array
		for (int i = nums.length - 1; i > 0; --i) {
			if (nums[i] > nums[i - 1]) {
				inversionIndex = i - 1;
				break;
			}
		}
		if (inversionIndex == -1) {
			reverseArray(nums);
			return;
		}
		// find smallest value just greater than the target
		int target = nums[inversionIndex];
		int end = nums.length - 1;
		int smallestInd = end;
		while (end > inversionIndex) {
			if (nums[end] > target && nums[end] < nums[smallestInd]) {
				smallestInd = end;
			}
			end--;
		}
		nums[inversionIndex] = nums[inversionIndex] ^ nums[smallestInd];
		nums[smallestInd] = nums[inversionIndex] ^ nums[smallestInd];
		nums[inversionIndex] = nums[inversionIndex] ^ nums[smallestInd];

	}

	private void reverseArray(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			nums[start] = nums[start] ^ nums[end];
			nums[end] = nums[start] ^ nums[end];
			nums[start] = nums[start] ^ nums[end];
			start++;
			end--;
		}
	}
}
