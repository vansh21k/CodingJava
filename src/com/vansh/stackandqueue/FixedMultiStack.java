package com.vansh.stackandqueue;

/**
 * 
 * For stack 1 we use 0-n/3, stack 2 we use n/3 to 2n/3 and then upto n
 * @author vanshkhurana
 *
 */
public class FixedMultiStack {
	private int numberOfStacks = 3;
	/**
	 * Size of each stack
	 */
	private int stackCapacity;
	private int [] values; 
	private int[] sizes;
	
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];		
	}
	
	public void push(int stackNum, int value) {
		if (isFull(stackNum)) {
			return;
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
			return -1;
		}
		int topIndex = indexOfTop(stackNum);
		int val = values[topIndex]; 
		values[topIndex] = 0;
		sizes[stackNum]--;
		return val;
	}

	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int cur_size = sizes[stackNum];
		return offset + cur_size -1;
	}
	
	private boolean isEmpty(int stackNum) {
		if (sizes[stackNum] == 0) {
			return true;
		}
		return false;
	}

	private boolean isFull(int stackNum) {
		if (sizes[stackNum] < stackCapacity) {
			return false;
		}
		return true;
	}
	
}
