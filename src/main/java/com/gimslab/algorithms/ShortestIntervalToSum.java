package com.gimslab.algorithms;

import java.util.Arrays;

public class ShortestIntervalToSum {

	private int find(int[] arr, int base) {
		Window win = new Window(arr);
		int shortest = arr.length + 1;
		while (true) {
			System.out.println(win);
			if (win.sum < base) {
				win.expandRight();
				if (win.reachRightEnd() && win.sum < base)
					break;
			} else {
				shortest = Math.min(shortest, win.interval());
				win.shirinkLeft();
				if (win.interval() == 0)
					break;
			}
			System.out.println("===>" + shortest);
		}
		System.out.println("===>" + shortest);
		return shortest <= arr.length ? shortest : 0;
	}

	class Window {
		private int[] arr;
		int left;
		int right;
		int sum;

		Window(int[] arr) {
			this.arr = arr;
			left = right = 0;
			sum = arr[left];
		}

		@Override
		public String toString() {
			int[] w = Arrays.copyOfRange(arr, left, right + 1);
			return "W[" + left + ":" + right + ":" + Arrays.toString(w) + ":" + sum + "]";
		}

		boolean shirinkLeft() {
			sum -= arr[left];
			left++;
			return right - left < 0;
		}

		void expandRight() {
			right++;
			sum += arr[right];
		}

		public boolean reachRightEnd() {
			return right >= arr.length - 1;
		}

		int interval() {
			return right - left + 1;
		}
	}

	public static void main(String[] args) {
		ShortestIntervalToSum sol = new ShortestIntervalToSum();
//		int[] arr = new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
		int[] arr = new int[]{1, 1, 2, 9, 1, 8, 4, 7, 5, 35};
		int r = sol.find(arr, 35);
		System.out.println(Arrays.toString(arr));
		System.out.println(r);
	}
}
