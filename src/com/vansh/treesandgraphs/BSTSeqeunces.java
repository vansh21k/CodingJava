package com.vansh.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTSeqeunces {
	List<List<Integer>> allSequences(TreeNode node){
		List<List<Integer>>result = new ArrayList<>();
		if (node == null) {
			result.add(new LinkedList<>());
			return result;
		}
		
		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.val);
		List<List<Integer>> leftSequences = allSequences(node.left);
		List<List<Integer>> rightSequences = allSequences(node.right);
		// weave together each list from left and right subsequences
		for (List<Integer> left : leftSequences) {
			for (List<Integer> right: rightSequences) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

	private void weaveLists(List<Integer> first, List<Integer> second, ArrayList<LinkedList<Integer>> results,
			LinkedList<Integer> prefix) {
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
		}
		int headFirst = first.remove(0);
		prefix.add(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.add(0, headFirst);
		
		int headSecond = second.remove(0);
		prefix.add(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.add(0, headSecond);	
	}
}
