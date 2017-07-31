package com.vansh.arrays;

public class MaxAreaContainer {
	public int maxArea(int[] height) {
		int maxArea = -1;
		int curArea;
		int l = 0, r = height.length-1;
		while (l < r & l < height.length && r < height.length) {
			curArea = (r - l + 1) * (Math.min(height[l], height[r]));
			maxArea = Math.max(curArea, maxArea);
			if (height[l] <= height[r]) {
				l++;
			}else {
				r++;
			}
		}
		return maxArea;
	}
}
