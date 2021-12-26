package com.gimslab.algorithms;

import java.util.Arrays;

public class MatrixTraversal {
	static Dir SOUTH = new Dir(1, 0, "S");
	static Dir EAST = new Dir(0, 1, "E");
	static Dir NORTH = new Dir(-1, 0, "N");
	static Dir WEST = new Dir(0, -1, "W");

	static {
		SOUTH.next = EAST;
		EAST.next = NORTH;
		NORTH.next = WEST;
		WEST.next = SOUTH;
	}

	private int[] solution(int[][] input) {
		int resultLength = input.length * input[0].length;
		int[] result = new int[resultLength];
		Arrow arrow = new Arrow(new Loc(0, 0), SOUTH);
		int i = 0;
		do {
			result[i++] = input[arrow.loc.y][arrow.loc.x];
			arrow = nextArrow(input, arrow);
		} while (i < resultLength);
		return result;
	}

	private Arrow nextArrow(int[][] input, Arrow curArrow) {
		return curArrow.getNext(input.length, input[0].length);
	}

	class Arrow {
		Loc loc;
		Dir dir;

		Arrow(Loc loc, Dir dir) {
			this.loc = loc;
			this.dir = dir;
		}

		public Arrow getNext(int height, int width) {
			if (loc.isTurningPoint(height, width))
				dir = dir.next;
			return new Arrow(loc.nextWith(dir), dir);
		}

		public String toString() {
			return loc + "(" + dir + ")";
		}
	}

	class Loc {
		int y, x;

		Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Loc nextWith(Dir dir) {
			return new Loc(y + dir.yincr, x + dir.xincr);
		}

		public boolean isTurningPoint(int height, int width) {
//			System.out.printf("%s %s %s %s %s %s %s\n", y, x, height / 2, width / 2, height, width, (width-x-1));
			// south west
			if (y >= height / 2 && x < width / 2
					&& (height - y - 1) == x)
				return true;
			// south east
			if (y >= height / 2 && x >= width / 2
					&& (height - y - 1) == (width - x - 1))
				return true;
			// north east
			if (y <= height / 2 && x > width / 2
					&& y == (width - x - 1))
				return true;
			// north west
			if (y < height / 2 && x <= width / 2
					&& y == x - 1)
				return true;
			return false;
		}

		public String toString() {
			return y + "," + x;
		}
	}

	static class Dir {
		public int yincr;
		public int xincr;
		public String name;
		public Dir next;

		Dir(int yincr, int xincr, String name) {
			this.yincr = yincr;
			this.xincr = xincr;
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}

	public static void main(String[] args) {
		int[][] input = {
//				{1, 2, 3, 4},
//				{5, 6, 7, 8},
//				{9, 10, 11, 12},
//				{13, 14, 15, 16}};
//		 1 5 9 13 14 15 16 12 8 4 3 2 6 10 11 7
//				{1, 2, 3, 4, 5},
//				{6, 7, 8, 9, 10},
//				{11, 12, 13, 14, 15},
//				{16, 17, 18, 19, 20}};
				// 1 6 11 16 17 18 19 20 15 10 5 4 3 2 7 12 13 14 9 8
//				{1, 2, 3, 4, 5, 1},
//				{6, 7, 8, 9, 10, 2},
//				{11, 12, 13, 14, 15, 3},
//				{16, 17, 18, 19, 20, 4}};
				// 4x5
				{11, 12, 13, 14},
				{15, 16, 17, 18},
				{19, 20, 21, 22},
				{23, 24, 25, 26},
				{27, 28, 29, 30}};
		printOut(input);
		System.out.println("----");
		int[] output = new MatrixTraversal().solution(input);
		printOut(output);
	}

	private static void printOut(int[][] input) {
		Arrays.asList(input)
				.forEach(row -> printOut(row));
	}

	private static void printOut(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}
