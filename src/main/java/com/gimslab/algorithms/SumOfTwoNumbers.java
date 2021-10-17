package com.gimslab.algorithms;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumbers {
	public static void main(String[] args) {
		SumOfTwoNumbers s = new SumOfTwoNumbers();
		System.out.printf("Solution1 8:%s, 7:%s, 10:%s, 15:%s\n",
				s.solution1(8), s.solution1(7), s.solution1(10), s.solution1(15));
		System.out.printf("Solution2 8:%s, 7:%s, 10:%s, 15:%s\n",
				s.solution2(8), s.solution2(7), s.solution2(10), s.solution2(15));
	}

	int[] arr = {5, 3, 19, 10};
	Map<Integer, Integer> map = new HashMap<>();

	// for solution2
	SumOfTwoNumbers() {
		for (int i = 0; i < arr.length; i++)
			map.put(arr[i], i);
	}

	private boolean solution2(int n) {
		for (int a : arr) {
			if (a * 2 == n)
				continue;
			Integer b = map.get(n - a);
			if (b != null)
				return true;
		}
		return false;
	}

	private boolean solution1(int n) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == n)
					return true;
			}
		}
		return false;
	}
}
