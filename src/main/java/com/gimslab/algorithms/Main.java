package com.gimslab.algorithms;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 2, 2};
		test(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("hi");
	}

	private static void test(int[] arr) {
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
	}
}
