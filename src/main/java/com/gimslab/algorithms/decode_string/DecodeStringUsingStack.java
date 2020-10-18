package com.gimslab.algorithms.decode_string;

import java.util.Stack;

public class DecodeStringUsingStack {
	private String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == ']')
				makeTokenReverse(stack, '[')
						.chars()
						.forEach(it -> stack.push((char) it));
			else
				stack.push(c);
		}
		return extractToString(stack);
	}

	private String makeTokenReverse(Stack<Character> stack, char delimiter) {
		StringBuilder sb = new StringBuilder();
		char p;
		while ((p = stack.pop()) != delimiter)
			sb.insert(0, p);
		int time = stack.pop() - '0';
		return times(sb.toString(), time);
	}

	private String times(String str, int time) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < time; i++)
			sb.append(str);
		return sb.toString();
	}

	private String extractToString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.insert(0, stack.pop());
		return sb.toString();
	}

	public static void main(String[] args) {
		test("3[q]2[rs]", "qqqrsrs");
		test("3[q2[s]]", "qssqssqss");
		test("2[qrs]3[sd]ef", "qrsqrssdsdsdef");
		test("qrs3[sd]xyz", "qrssdsdsdxyz");
		test("q2[3[sd]]xyz", "qsdsdsdsdsdsdxyz");
	}

	private static void test(String enc, String expected) {
		String dec = new DecodeStringUsingStack().decodeString(enc);
		System.out.printf("%s : %s : %s\n", enc, dec, dec.equals(expected));
	}
}
