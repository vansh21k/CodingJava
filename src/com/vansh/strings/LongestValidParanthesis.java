package com.vansh.strings;

import java.util.Stack;

public class LongestValidParanthesis {
	public int longestValidParentheses(String s) {
	 	if (s == null || s.length() < 2) {
	 		return 0;
	 	}
		Stack<Integer> stack = new Stack<>();
		int maxLen = 0;
	 	// initialize the stack
	 	stack.push(-1);
	 	for (int i = 0; i < s.length(); ++i) {
	 		if (s.charAt(i) == '(') {
	 			stack.push(i);
	 		} else {
	 			stack.pop();
	 			if (!stack.isEmpty()) {
	 				maxLen = Math.max(maxLen, i - stack.peek());
	 			} else {
	 				stack.push(i); 
	 			}
	 		}
	 	}
	 	return maxLen;
	}
}
