package com.gimslab.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixTraversalAsCollecting {

	private int[] solution(int[][] input) {
		List<List<Integer>> verLeft = collectVerticalFromLeft(input);
		List<List<Integer>> verRight = collectVerticalFromRight(input);
		List<List<Integer>> horTop = collectHorizontalFromTop(input);
		List<List<Integer>> horBottom = collectHorizontalFromBottom(input);

		int[] result = new int[input.length * input[0].length];
		int i = 0;
		do {
			if (verLeft.size() > 0)
				for (int v : verLeft.remove(0))
					result[i++] = v;
			if (horBottom.size() > 0)
				for (int v : horBottom.remove(0))
					result[i++] = v;
			if (verRight.size() > 0)
				for (int v : verRight.remove(0))
					result[i++] = v;
			if (horTop.size() > 0)
				for (int v : horTop.remove(0))
					result[i++] = v;
		} while (verLeft.size() + verRight.size() + horTop.size() + horBottom.size() > 0);
		return result;
	}

	private List<List<Integer>> collectVerticalFromLeft(int[][] input) {
		int height = input.length;
		int width = input[0].length;
		List<List<Integer>> collected = new ArrayList<>();
		int hiStart = 0;
		int hiLength = height;
		for (int wi = 0; wi < Math.ceil((double) width / 2.0); wi++) {
			List<Integer> ver = new ArrayList<>();
			for (int hi = hiStart; hi < hiLength; hi++)
				ver.add(input[hi][wi]);
			collected.add(ver);
			hiStart++;
			hiLength--;
		}
		return collected;
	}

	private List<List<Integer>> collectVerticalFromRight(int[][] input) {
		int height = input.length;
		int width = input[0].length;
		List<List<Integer>> collected = new ArrayList<>();
		int hiStart = height - 1;
		int hiLength = height;
		for (int wi = width - 1; wi >= width / 2; wi--) {
			List<Integer> ver = new ArrayList<>();
			for (int hi = hiStart; hi >= height - hiLength; hi--)
				ver.add(input[hi][wi]);
			collected.add(ver);
			hiStart--;
			hiLength--;
		}
		return collected;
	}

	private List<List<Integer>> collectHorizontalFromTop(int[][] input) {
		int height = input.length;
		int width = input[0].length;
		List<List<Integer>> collected = new ArrayList<>();
		int wiStart = width - 1;
		int wiLength = width - 1;
		for (int hi = 0; hi < Math.ceil((double) height / 2.0); hi++) {
			List<Integer> ver = new ArrayList<>();
			for (int wi = wiStart - 1; wi >= width - wiLength; wi--)
				ver.add(input[hi][wi]);
			collected.add(ver);
			wiStart--;
			wiLength--;
		}
		return collected;
	}

	private List<List<Integer>> collectHorizontalFromBottom(int[][] input) {
		int height = input.length;
		int width = input[0].length;
		List<List<Integer>> collected = new ArrayList<>();
		int wiStart = 1;
		int wiLength = width - 1;
		for (int hi = height - 1; hi >= height / 2; hi--) {
			List<Integer> ver = new ArrayList<>();
			for (int wi = wiStart; wi < wiLength; wi++)
				ver.add(input[hi][wi]);
			collected.add(ver);
			wiStart++;
			wiLength--;
		}
		return collected;
	}

	public static void main(String[] args) {
//		int[][] input = {
//				{1, 2, 3, 4},
//				{5, 6, 7, 8},
//				{9, 10, 11, 12},
//				{13, 14, 15, 16}};
		int[][] input = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		int[] output = new MatrixTraversalAsCollecting().solution(input);
		printOut(input);
		System.out.println("----");
		printOut(output);
	}

	private static void printOut(int[][] input) {
		Arrays.asList(input)
				.forEach(row -> printOut(row));
	}

	private static void printOut(int[] arr) {
		for (int i : arr)
			System.out.print(i + ",");
		System.out.println();
	}
}
