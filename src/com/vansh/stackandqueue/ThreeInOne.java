package com.vansh.stackandqueue;

public class ThreeInOne {
	private StackInfo[] info;
	private int[] values;

	public ThreeInOne(int numberOfStacks, int defaultSize) {
		info = new StackInfo[numberOfStacks];
		for (int i = 0; i < numberOfStacks; ++i) {
			info[i] = new StackInfo(defaultSize * i, defaultSize);
		}
		values = new int[defaultSize * numberOfStacks];
	}

	public void push(int stackNum, int value) {
		if (allStacksAreFull()) {
			return;
		}
		StackInfo stack = info[stackNum];
		if (stack.isFull()) {
			expand(stackNum);
		}
		stack.size++;
		values[stack.lastElementIndex()] = value;
	}

	public int pop(int stackNum) {
		StackInfo stack = info[stackNum];
		if (stack.isEmpty()) {
			return -1;
		}
		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		stack.size--;
		return value;

	}

	private void expand(int stackNum) {
		shift((stackNum + 1) % info.length);
		info[stackNum].capacity++;

	}

	private void shift(int stackNum) {
		StackInfo stack = info[stackNum];
		if (stack.size >= stack.capacity) {
			int nextStack = (stackNum + 1) % info.length;
			shift(nextStack);
			stack.capacity++;
		}
		// now we shift all elements by one position
		int index = stack.lastCapacityIndex();
		while (stack.isWithinCapacity(index)) {
			values[index] = values[previousIndex(index)];
		}

		values[stack.start] = 0;
		stack.start = nextIndex(stack.start);
		stack.capacity--;

	}

	private int previousIndex(int index) {

		return adjustIndex(index - 1);
	}

	private int nextIndex(int index) {
		return adjustIndex(index + 1);
	}

	public boolean allStacksAreFull() {
		return numberOfElements() == values.length;
	}

	public int numberOfElements() {
		int size = 0;
		for (StackInfo sd : info) {
			size += sd.size;
		}
		return size;
	}

	private int adjustIndex(int index) {
		int max = values.length;
		return ((index % max) + max) % max;
	}

	class StackInfo {
		public int start, size, capacity;

		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
		}

		public boolean isWithinCapacity(int index) {
			if (index < 0 || index > values.length) {
				return false;
			}
			int contigousIndex = (index < start) ? index + values.length : index;
			int end = start + capacity;
			return start <= contigousIndex && contigousIndex < end;
		}

		public int lastCapacityIndex() {
			return adjustIndex(start + capacity - 1);
		}

		public int lastElementIndex() {
			return adjustIndex(start + size - 1);
		}

		public boolean isFull() {
			return size == capacity;
		};

		public boolean isEmpty() {
			return size == 0;
		}
	}

}
