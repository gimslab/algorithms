package com.gimslab.algorithms;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

//	static int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
	static int[] nums = {13, 14, 15, 11, 9, 12, 16, 13};

	private int[] solution3() {
		int[] result = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			// TODO 또 다른 방법이 있을까?
		}
		return result;
	}

	private int[] solution2() {
		int[] result = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
				result[stack.peek()] = i - stack.pop();
			stack.push(i);
		}
		return result;
	}

	private int[] solution1() {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					result[i] = j - i;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println("nums: " + Arrays.toString(nums));
		int[] result1 = new DailyTemperatures().solution1();
		System.out.println("sol1: "+ Arrays.toString(result1));

		int[] result2 = new DailyTemperatures().solution2();
		System.out.println("sol2: "+ Arrays.toString(result2));

		int[] result3 = new DailyTemperatures().solution3();
		System.out.println("sol3: "+ Arrays.toString(result3));
	}
}
