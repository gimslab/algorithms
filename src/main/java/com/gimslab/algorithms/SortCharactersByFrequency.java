package com.gimslab.algorithms;

import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {
	public static void main(String[] args) {
		test("tree");
		test("ttree");
		test("ttreee");
		test("t");
		test("tr");
		test("tre");
		test("trea");
		test("tree");
		test("teee");
		test("eeee");
	}

	int loop = 0;

	private static void test(String input) {
		SortCharactersByFrequency sol = new SortCharactersByFrequency();
		System.out.printf("%s ==> %s (loop %s)\n", input, sol.sort(input), sol.loop);
	}

	private String sort(String str) {
		return makeString(
				reverse(
						collectFrequency(str)),
				str.length());
	}

	private Map<Character, Integer> collectFrequency(String str) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char c : str.toCharArray()) {
			loop++;
			freqMap.computeIfPresent(c, (character, integer) -> ++integer);
			freqMap.putIfAbsent(c, 1);
		}
		return freqMap;
	}

	private Map<Integer, String> reverse(Map<Character, Integer> map) {
		Map<Integer, String> rev = new HashMap<>();
		for (Map.Entry<Character, Integer> es : map.entrySet()) {
			loop++;
			rev.computeIfPresent(es.getValue(), (integer, s) -> s + es.getKey());
			rev.putIfAbsent(es.getValue(), es.getKey().toString());
		}
		return rev;
	}

	private String makeString(Map<Integer, String> map, int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = length; i > 0; i--) {
			loop++;
			sb.append(
					multiplyForEachChar(map.getOrDefault(i, ""), i));
		}
		return sb.toString();
	}

	private String multiplyForEachChar(String str, int i) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			loop++;
			sb.append(multiply(c, i));
		}
		return sb.toString();
	}

	private String multiply(char c, int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			loop++;
			sb.append(c);
		}
		return sb.toString();
	}
}
