package com.vansh.treesandgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Traversals {

	public static void inorderWithoutRecursion(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while (current != null && current.left != null) {
			stack.push(current);
			current = current.left;

		}

		while (stack.size() > 0) {
			current = stack.pop();
			System.out.println(current.val);

			if (current.right != null) {
				current = current.right;
				while (current != null && current.left != null) {
					stack.push(current);
					current = current.left;
				}
			}

		}
	}

	public static void morrisInorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode current, predecessor;
		current = root;
		while (current != null) {
			// if current left is null then visit the node and move to right side
			if (current.left == null) {
				System.out.println(current.val);
				current = current.right;
			} else {
				// else we find the predecessor
				predecessor = current.left;
				// find in order predecessor of the node
				while (predecessor.right != null && predecessor.right != current) {
					predecessor = predecessor.right;
				}
				// if predeccor right is not connector, then connect the predecessor to currrent
				// and move to left
				if (predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				}
				// if we are reexploring this time, then disconnect to null and visit the node
				// and move to the right side
				else {
					predecessor.right = null;
					System.out.println(current.val);
					current = current.right;
				}
			}
		}
	}

	public static void preorderWithoutRecursion(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode next = stack.pop();
			System.out.println(next + " ");
			if (next.right != null) {
				stack.push(next.right);
			}
			if (next.left != null) {
				stack.push(next.left);
			}
		}

	}

	public static void morrisPreOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode current, predecessor;
		current = root;
		while (current != null) {
			// if current left is null then visit the node and move to right side
			if (current.left == null) {
				System.out.println(current.val);
				current = current.right;
			} else {
				// else we find the predecessor
				predecessor = current.left;
				// find in order predecessor of the node
				while (predecessor.right != null && predecessor.right != current) {
					predecessor = predecessor.right;
				}
				// if predeccor right is not connector, then connect the predecessor to currrent
				// and move to left
				if (predecessor.right == null) {
					predecessor.right = current;
					System.out.println(current.val);
					current = current.left;
				}
				// if we are reexploring this time, then disconnect to null and visit the node
				// and move to the right side
				else {
					predecessor.right = null;

					current = current.right;
				}
			}
		}
	}
	
	public static void diagonalTraversal(TreeNode root) {
		// Map of level to list of nodes
		Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
		populateDiagonalMap(root, diagonalMap, 0);
		
	}

	private static void populateDiagonalMap(TreeNode root, Map<Integer, List<Integer>> diagonalMap, int level) {
		if (root == null) {
			return;
		}
		List<Integer> currentLevel = diagonalMap.get(level);
		if (currentLevel == null) {
			currentLevel = new ArrayList<>();
			diagonalMap.put(level, currentLevel);
		}
		currentLevel.add(root.val);
		populateDiagonalMap(root.left, diagonalMap, level+1);
		populateDiagonalMap(root.right, diagonalMap, level);
		
	}
	
}
