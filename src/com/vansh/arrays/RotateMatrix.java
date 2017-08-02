package com.vansh.arrays;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (matrix.length != matrix[0].length) {
			return;
		}
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i <= last; ++i) {
				int offset = i - first;
				int temp = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = temp;
			}
		}
	}

}
