package com.gimslab.algorithms;

import java.util.HashMap;
import java.util.Map;

public class ShortestIntervalSatisfyingTheSum {
	public static void main(String[] args) {
		int targetSum = 50;
		ShortestIntervalSatisfyingTheSum s1 = new ShortestIntervalSatisfyingTheSum();
		System.out.printf("SOL1 answer: %s, totalLoop: %s\n", s1.solution1(targetSum), s1.totalLoop); // O(n^2)
		ShortestIntervalSatisfyingTheSum s2 = new ShortestIntervalSatisfyingTheSum();
		System.out.printf("SOL2 answer: %s, totalLoop: %s\n", s2.solution2(targetSum), s2.totalLoop);
		ShortestIntervalSatisfyingTheSum s3 = new ShortestIntervalSatisfyingTheSum();
		System.out.printf("SOL3 answer: %s, totalLoop: %s\n", s3.solution3(targetSum), s3.totalLoop);
	}

	int[] nums = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
	int totalLoop = 0;

	private int solution3(int targetSum) {
		int windowStart = 0, windowEnd = -1, windowSum = 0;
		int result = Integer.MAX_VALUE;
		do {
//			System.out.println("----");
			do {
				totalLoop++;
				windowEnd++;
				windowSum += nums[windowEnd];
				status(windowStart, windowEnd, windowSum, targetSum, result);
				if (windowSum > targetSum) {
					result = Math.min(result, windowEnd - windowStart + 1);
					break;
				}
			} while (windowEnd < nums.length - 1);
//			System.out.println("----");
			do {
				totalLoop++;
				windowSum -= nums[windowStart];
				windowStart++;
				status(windowStart, windowEnd, windowSum, targetSum, result);
				if (windowSum > targetSum)
					result = Math.min(result, windowEnd - windowStart + 1);
				else
					break;
			} while (windowStart < windowEnd);
		} while (windowEnd < nums.length - 1);
		return result;
	}

	private void status(int windowStart, int windowEnd, int windowSum, int targetSum, int result) {
//		System.out.printf("st:%s ed:%s, wsum:%s, tsum:%s, result:%s\n", windowStart, windowEnd, windowSum, targetSum, result);
	}

	private int solution2(int s) {
		for (int intv = 1; intv <= nums.length; intv++) {
			for (int i = 0; i < nums.length - intv + 1; i++) {
				if (windowsum2(i, intv) > s)
					return intv;
			}
		}
		return -1;
	}

	Map<String, Integer> memory = new HashMap<>();

	private int windowsum2(int startIndex, int windowSize) {
		totalLoop++;
		if (windowSize == 1)
			return nums[startIndex];
		if (windowSize == 2) {
			int s = nums[startIndex] + nums[startIndex + 1];
			memory.put(startIndex + "," + windowSize, s);
			return s;
		}
		int sum = memory.get(startIndex + "," + (windowSize - 1))
				+ nums[startIndex + windowSize - 1];
		memory.put(startIndex + "," + windowSize, sum);
		return sum;
	}

	private int solution1(int s) {
		for (int intv = 1; intv <= nums.length; intv++) {
			for (int i = 0; i < nums.length - intv + 1; i++) {
				if (windowsum1(i, intv) > s)
					return intv;
			}
		}
		return -1;
	}

	private int windowsum1(int startIndex, int windowSize) {
		int sum = 0;
		for (int i = startIndex; i < startIndex + windowSize; i++) {
			sum += nums[i];
			totalLoop++;
		}
		return sum;
	}
}
