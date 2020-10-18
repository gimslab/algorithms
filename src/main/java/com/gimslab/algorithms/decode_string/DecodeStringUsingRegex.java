package com.gimslab.algorithms.decode_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DecodeStringUsingRegex {

	private static final String REGEX = "[0-9]\\[[^\\[\\]]*]";
	private static final Pattern P = Pattern.compile(REGEX);

	private static String decodeString(String s) {
		String str = s;
		Matcher m = P.matcher(str);
		while (m.find()) {
			String found = m.group();
			String decoded = decodeToken(found);
			str = str.replaceFirst(REGEX, decoded);
			m = P.matcher(str);
		}
		return str;
	}

	private static String decodeToken(String token) { // not contain brackets
		int cnt = parseInt(token.substring(0, 1));
		String body = token.replaceAll("[0-9\\[\\]]", "");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++)
			sb.append(body);
		return sb.toString();
	}

	public static void main(String[] args) {
		test("3[a]2[bc]", "aaabcbc");
		test("3[a2[c]]", "accaccacc");
		test("2[abc]3[cd]ef", "abcabccdcdcdef");
		test("abc3[cd]xyz", "abccdcdcdxyz");
		test("q2[3[sd]]xyz", "qsdsdsdsdsdsdxyz");
	}

	private static void test(String enc, String expected) {
		String dec = decodeString(enc);
		System.out.printf("%s : %s : %s\n", enc, dec, dec.equals(expected));
	}
}
