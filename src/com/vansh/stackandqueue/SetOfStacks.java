package com.vansh.stackandqueue;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack<Integer>> stacks = new ArrayList<>();
	int threshold;

	public SetOfStacks(int num, int capacity) {
		this.threshold = capacity;
	}

	public void push(int val) {
		Stack<Integer> last = getLastStack();
		if (last != null && !isFull(last)) {
			last.push(val);
		} else {
			Stack<Integer> newStack = new Stack<>();
			newStack.push(val);
			stacks.add(newStack);

		}

	}

	public int pop() {
		Stack<Integer> last = getLastStack();
		if (last == null) {
			return -1;
		}
		int val = last.pop();
		if (last.size() == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return val;
	}

	private boolean isFull(Stack<Integer> last) {
		return last != null && last.size() == threshold;
	}

	private Stack<Integer> getLastStack() {
		if (stacks != null && stacks.size() > 0) {
			return stacks.get(stacks.size() - 1);
		}
		return null;
	}
}
