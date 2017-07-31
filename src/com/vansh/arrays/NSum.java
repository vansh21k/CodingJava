package com.vansh.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NSum {
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { 0, 0, 0 }, 1));
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> alreadySeenMap = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (alreadySeenMap.containsKey(target - nums[i])) {
				return new int[] { alreadySeenMap.get(target - nums[i]), i };
			} else {
				alreadySeenMap.put(nums[i], i);
			}
		}
		return null;
	}

	public static int[] twoSum(int[] nums, int target, int startPos) {
		HashMap<Integer, Integer> alreadySeenMap = new HashMap<>();
		for (int i = startPos; i < nums.length; ++i) {
			if (alreadySeenMap.containsKey(target - nums[i])) {
				return new int[] { alreadySeenMap.get(target - nums[i]), i };
			} else {
				alreadySeenMap.put(nums[i], i);
			}
		}
		return null;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> toReturn = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; ++i) {
			int target = nums[i];
			int[] twoSumCandidate = twoSum(nums, target, i + 1);
			if (twoSumCandidate != null) {
				toReturn.add(Arrays.asList(nums[i], nums[twoSumCandidate[0]], nums[twoSumCandidate[1]]));
			}
		}
		return toReturn;
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int curCandidate = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(sum - target) < Math.abs(curCandidate - target)) {
					curCandidate = sum;
				}
				if (sum <= target) {
					j++;
				} else {
					k--;
				}

			}
		}
		return curCandidate;
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		// TODO: Later
		return null;
	}
	
	
}
