package com.gimslab.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SlidingWindowMaximum {

	private final static int[] nums = {9, 3, -1, -3, 5, 3, 6, 7};

	// Queue nums
	private int[] solution4(int windowSize) {
		int[] result = new int[nums.length - windowSize + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			trimQ(queue, windowSize);
			popOutQLessThanCurrentNum(queue, nums[i]);
			queue.add(nums[i]);
			if (i >= windowSize - 1)
				result[i - windowSize + 1] = queue.peek();
		}
		return result;
	}

	private void popOutQLessThanCurrentNum(Queue<Integer> queue, int num) {
		while (queue.size() > 0 && queue.peek() < num)
			queue.poll();
	}

	// Queue index
	private int[] solution3(int windowSize) {
		int[] result = new int[nums.length - windowSize + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			trimQ(queue, windowSize);
			popOutQLessThanCurrent(queue, nums[i]);
			queue.add(i);
			if (i >= windowSize - 1)
				result[i - windowSize + 1] = nums[queue.peek()];
		}
		return result;
	}

	private void popOutQLessThanCurrent(Queue<Integer> queue, int num) {
		while (queue.size() > 0 && nums[queue.peek()] < num)
			queue.poll();
	}

	private void trimQ(Queue<Integer> queue, int windowSize) {
		if (queue.size() >= windowSize)
			queue.poll();
	}

	private int[] solution1(int windowSize) {
		int[] result = new int[nums.length - windowSize + 1];
		int[] window;
		for (int i = 0; i < nums.length - windowSize + 1; i++) {
			window = copyWindow(i, windowSize);
			result[i] = max(window);
		}
		return result;
	}

	private int max(int[] window) {
		return Arrays.stream(window).max().orElseThrow(RuntimeException::new);
	}

	private int[] copyWindow(int idx, int windowSize) {
		int[] window = new int[windowSize];
		System.arraycopy(nums, idx, window, 0, windowSize);
		return window;
	}

	public static void main(String[] args) {
		System.out.println("nums: " + Arrays.toString(nums));
		SlidingWindowMaximum q = new SlidingWindowMaximum();
		int windowSize = 3; // k
		System.out.println("windowSize: " + windowSize);
		System.out.println("solution 1:  " + Arrays.toString(q.solution1(windowSize))); // O(kn)
		System.out.println("solution 3:  " + Arrays.toString(q.solution3(windowSize))); // O(n) use Que
		System.out.println("solution 4:  " + Arrays.toString(q.solution4(windowSize))); // O(n) Que num itself
	}
}
