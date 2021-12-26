package com.gimslab.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeRange {

	private static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		List<int[]> result = new ArrayList<>();
		int[] last = intervals[0];
		for (int[] anInt : intervals) {
			if (overlap(last, anInt)) {
				last = merge(last, anInt);
			} else {
				result.add(last);
				last = anInt;
			}
		}
		result.add(last);
		return toArray(result);
	}

	private static int[][] toArray(List<int[]> arrays) {
		int[][] r = new int[arrays.size()][2];
		for (int i = 0; i < arrays.size(); i++) {
			r[i] = arrays.get(i);
		}
		return r;
	}

	private static boolean overlap(int[] a, int[] b) {
		return inBetween(b[0], a) && (inBetween(a[1], b) || inBetween(b[1], a))
				|| inBetween(b[1], a) && (inBetween(a[0], b) || inBetween(b[0], a));
	}

	private static boolean inBetween(int a, int[] b) {
		return b[0] <= a && a <= b[1];
	}

	private static int[] merge(int[] a, int[] b) {
		return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
	}

	public static void main(String[] args) {
//		int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//		int[][] ints = {{1, 4}, {4, 5}};
//		int[][] ints = {{1, 4}, {0, 3}, {0, 8}};
//		int[][] ints = {{2, 5}, {4, 6}, {0, 1}, {3, 7}};
		int[][] ints = {{0, 1}, {0, 3}, {0, 2}, {0, 4}};
		int[][] r = merge(ints);
		print(ints);
		print(r);
	}

	private static void print(int[][] ints) {
		for (int[] anInt : ints)
			System.out.print(Arrays.toString(anInt));
		System.out.println();
	}
}
