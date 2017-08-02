package com.vansh.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingBased {

	public static void main(String[] args) {
		System.out.println("Display all subsets");
		int[] arr = { 2, 2, 5, 1 };
		List<List<Integer>> allSubs = subsets(arr);
		// for (List<Integer> eachSet : allSubs) {
		// System.out.println("Displaying subset");
		// for (int each : eachSet) {
		// System.out.print(each + "\t");
		// }
		// System.out.println();
		// }

		allSubs = permute(arr);
		for (List<Integer> eachSet : allSubs) {
			System.out.println("Displaying subset");
			for (int each : eachSet) {
				System.out.print(each + "\t");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> toReturn = new ArrayList<>();
		Arrays.sort(nums);
		findAllSubsets(toReturn, new ArrayList<Integer>(), nums, 0);
		return toReturn;
	}

	private static void findAllSubsets(List<List<Integer>> toReturn, ArrayList<Integer> tempList, int[] nums,
			int start) {
		toReturn.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; ++i) {
			tempList.add(nums[i]);
			findAllSubsets(toReturn, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	private static void findAllUniqueSubsets(List<List<Integer>> toReturn, ArrayList<Integer> tempList, int[] nums,
			int start) {
		toReturn.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; ++i) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			tempList.add(nums[i]);
			findAllSubsets(toReturn, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> toReturn = new ArrayList<>();
		Arrays.sort(candidates);
		generateAllCombeinations(toReturn, candidates, new ArrayList<Integer>(), target, 0);
		return toReturn;
	}

	private void generateAllCombeinations(List<List<Integer>> toReturn, int[] candidates, ArrayList<Integer> tempSol,
			int target, int start) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			toReturn.add(new ArrayList<>(tempSol));
		} else {
			for (int i = start; i < candidates.length; ++i) {
				tempSol.add(candidates[i]);
				generateAllCombeinations(toReturn, candidates, tempSol, target - candidates[i], i);
				tempSol.remove(tempSol.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> toReturn = new ArrayList<>();
		Arrays.sort(candidates);
		generateAllCombeinations2(toReturn, candidates, new ArrayList<Integer>(), target, 0);
		return toReturn;
    }

	private void generateAllCombeinations2(List<List<Integer>> toReturn, int[] candidates, ArrayList<Integer> tempSol,
			int target, int start) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			toReturn.add(new ArrayList<>(tempSol));
		} else {
			for (int i = start; i < candidates.length; ++i) {
				if (i > start && candidates[i]== candidates[i-1]) {
					continue;
				}
				tempSol.add(candidates[i]);
				generateAllCombeinations2(toReturn, candidates, tempSol, target - candidates[i], i + 1);
				tempSol.remove(tempSol.size() - 1);
			}
		}
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
