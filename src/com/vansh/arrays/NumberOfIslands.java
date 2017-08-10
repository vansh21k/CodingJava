package com.vansh.arrays;

public class NumberOfIslands {
	public static int numberOfIslands(int[][] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int islandCount = 0;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					++islandCount;
					visit(arr, i, j, visited);
				}
			}
		}
		return islandCount;
	}

	private static void visit(int[][] arr, int i, int j, boolean[][] visited) {
		// check for bounds
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
			return;
		}
		visited[i][j] = true;
		visit(arr, i + 1, j + 1, visited);
		visit(arr, i, j + 1, visited);
		visit(arr, i + 1, j, visited);
		visit(arr, i - 1, j, visited);
		visit(arr, i, j - 1, visited);
		visit(arr, i - 1, j - 1, visited);
		visit(arr, i, j + 1, visited);
		visit(arr, i + 1, j - 1, visited);

	}

}
