package com.gimslab.algorithms;

public class MultipleExceptOneValue {
	int looped = 0;

	private final static int[] nums = {1, 2, 3, 4, 5};

	private int productExcept(int index) {
		int result = 1;
		for (int i = 0; i < nums.length; i++) {
			looped++;
			if (i != index)
				result *= nums[i];
		}
		return result;
	}

	// v2 below
	private int preCalc = 1;

	private MultipleExceptOneValue() {
		for (int num : nums) {
			looped++;
			preCalc *= num;
		}
	}

	private int productExceptV2(int index) {
		return preCalc / nums[index];
	}

	public static void main(String[] args) {
		MultipleExceptOneValue v1 = new MultipleExceptOneValue();
		System.out.println(v1.productExcept(3));
		System.out.println(v1.productExcept(2));
		System.out.println(v1.productExcept(1));
		System.out.println("-- looped:" + v1.looped);

		MultipleExceptOneValue v2 = new MultipleExceptOneValue();
		System.out.println(v2.productExceptV2(3));
		System.out.println(v2.productExceptV2(2));
		System.out.println(v2.productExceptV2(1));
		System.out.println("-- looped:" + v2.looped);
	}
}
