package com.vansh.treesandgraphs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TreeAlgos {

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (isSymmetricHelper(root.left, root.right)) {
			return true;
		}

		return false;
	}

	private static boolean isSymmetricHelper(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		}
		return one.val == two.val && isSymmetricHelper(one.left, two.right) && isSymmetricHelper(one.right, two.left);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		zigzagLevelOrder(root);
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<TreeNode>> toReturn = new LinkedList<>();
		List<TreeNode> current = new LinkedList<>();
		List<TreeNode> parent;
		boolean inOrder = true;
		if (root != null) {
			current.add(root);
		}
		while (!current.isEmpty()) {
			toReturn.add(current);
			parent = current;
			current = new LinkedList<>();
			for (int i = 0; i < parent.size(); ++i) {
				TreeNode tempNode = parent.get(i);
				if (inOrder) {
					if (tempNode.left != null) {
						current.add(tempNode.left);
					}
					if (tempNode.right != null) {
						current.add(tempNode.right);
					}
				} else {

					if (tempNode.right != null) {
						current.add(tempNode.right);
					}
					if (tempNode.left != null) {
						current.add(tempNode.left);
					}
				}

			}
			inOrder = !inOrder;
		}

		return transformToValues(toReturn);

	}

	private static List<List<Integer>> transformToValues(List<List<TreeNode>> list) {
		List<List<Integer>> toReturn = new LinkedList<>();
		for (int i = 0; i < list.size(); ++i) {
			LinkedList<Integer> thisLevel = new LinkedList<>();
			List<TreeNode> nodeToCopy = list.get(i);
			for (int j = 0; j < nodeToCopy.size(); ++j) {
				thisLevel.add(nodeToCopy.get(j).val);
			}
			toReturn.add(thisLevel);
		}
		return toReturn;
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lHeight = maxDepth(root.left);
		int rHeight = maxDepth(root.right);
		return 1 + Math.max(lHeight, rHeight);
    }

	public static boolean isValidBST(TreeNode root) {
		return isBinarySearchTreeHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBinarySearchTreeHelper(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (!(root.val >= minValue && root.val <= maxValue)) {
			return false;
		}
		return isBinarySearchTreeHelper(root.left, minValue, root.val)
				&& isBinarySearchTreeHelper(root.right, root.val, maxValue);
	}

	public static TreeNode createMinimalTree(int[] arr) {
		return createMinimalTreeHelper(arr, 0, arr.length - 1);
	}

	private static TreeNode createMinimalTreeHelper(int[] arr, int low, int high) {
		if (low < high) {
			int midIndex = low + (high - low) / 2;
			TreeNode root = new TreeNode(arr[midIndex]);
			root.left = createMinimalTreeHelper(arr, low, midIndex - 1);
			root.right = createMinimalTreeHelper(arr, midIndex + 1, high);
			return root;
		}
		return null;
	}

	public static List<List<TreeNode>> listOfDepths(TreeNode root) {
		List<List<TreeNode>> toReturn = new LinkedList<>();
		createListOfDepths(root, toReturn);
		return toReturn;

	}

	private static void createListOfDepths(TreeNode root, List<List<TreeNode>> toReturn) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> current = new LinkedList<>();
		current.add(root);

		LinkedList<TreeNode> parent;
		while (!current.isEmpty()) {
			toReturn.add(current);
			parent = current;
			current = new LinkedList<>();
			for (TreeNode each : parent) {
				if (each.left != null) {
					current.add(each.left);
				}
				if (each.right != null) {
					current.add(each.right);
				}
			}
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<TreeNode>> listOfDepths = listOfDepths(root);
        Collections.reverse(listOfDepths);
        return transformToValues(listOfDepths);
    }
	
	public static boolean isBalanced(TreeNode root) {
		int heightBalanced = checkHeight(root);
		if (heightBalanced == Integer.MIN_VALUE) {
			return false;
		}
		return true;
	}

	private static int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	


	
	

}
