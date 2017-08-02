package com.vansh.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMultiply {

	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] pos = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];

				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int p : pos)
			if (!(sb.length() == 0 && p == 0))
				sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> toReturn = new ArrayList<>();
		permuteAll(toReturn, new ArrayList<Integer>(), nums);
		return toReturn;
	}

	private void permuteAll(List<List<Integer>> toReturn, ArrayList<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			toReturn.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; ++i) {
				if (tempList.contains(nums[i])) {
					continue;
				}
				tempList.add(nums[i]);
				permuteAll(toReturn, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> toReturn = new ArrayList<>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		permuteAll2(toReturn, new ArrayList<Integer>(), nums, used);
		return toReturn;
	}
	
	private void permuteAll2(List<List<Integer>> toReturn, ArrayList<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			toReturn.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; ++i) {
				if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[nums[i-1]])) {
					continue;
				}
				
				tempList.add(nums[i]);
				used[i] = true;
				permuteAll2(toReturn, tempList, nums, used);
				tempList.remove(tempList.size() - 1);
				used[i] = false;
			}
		}

	}

}
