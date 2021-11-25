package com.gimslab.algorithms;

/*
Given a string s, you are allowed to convert it to a palindrome by adding
characters in front of it. Find and return the shortest palindrome
you can find by performing this transformation.
"aabaa"

Example 1:
Input: "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: "abcd"
Output: "dcbabcd"
*/


public class Palindrome {
	private static int l = 0;

	public static void main(String[] args) {
		testSolution("a", "a");
		testSolution("ab", "bab");
		testSolution("abc", "cbabc");
		testSolution("abbade", "edabbade");
		testSolution("racecarABC", "CBAracecarABC");
		testSolution("computer is my friend", "dneirf ym si retupmocomputer is my friend");
	}

	private static void testSolution(String question, String expected) {
		String result = new Palindrome().solution(question);
		System.out.printf("%s : %s : %s\n", result, result.equals(expected), l);
	}

	private String solution(String origin) { // abbade
		String rev = reverse(origin); // edabba
		int dupLen = findLongestDuplicationLengthFromOrigin(origin, rev); // abba => 4
		String remain = origin.substring(dupLen); // de
		String revRemain = reverse(remain); // ed
		return revRemain + origin;
	}

	private String reverse(String str) {
		char[] arr = str.toCharArray();
		char[] rev = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			l++;
			rev[arr.length - i - 1] = arr[i];
		}
		return new String(rev);
	}

	private int findLongestDuplicationLengthFromOrigin(String a, String b) {
		//   abbade
		// edabba
		for (int i = a.length(); i >= 1; i--) {
			l++;
			String token = a.substring(0, i);
			if (b.endsWith(token))
				return i;
		}
		return 0;
	}
}
