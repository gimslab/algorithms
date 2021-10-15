package com.gimslab.algorithms;

import java.util.Arrays;

// jds dsaf lkdf kdsa fkldsf, --> 5
// adsbf ldka ads? asd bfdal --> 5
// ds bf[l. akf dhj ds  --> 4
// 878  dwa WE DE --> 3
// 7475 dsfh ds  RAMU --> 3
// 748 dj. --> 1
// --> 21
public class HowManyWords {
	public static void main(String[] args) {
		String s = "How many eggs are in a half-dozen, 13?";
		System.out.println(HowManyWords.howMany(s));
	}

	private static int howMany(String s) {
		String[] arr = s.split(" ");
		return (int)Arrays.stream(arr)
				.filter(HowManyWords::isWord)
				.count();
	}

	private static boolean isWord(String w) {
		if (w.trim().length() == 0)
			return false;
		String r = w.replaceAll("[,.?!]$", "");
		r = r.replaceAll("[a-zA-Z-]", "");
		System.out.printf("(%s) --> (%s)\n", w, r);
		return r.length() == 0;
	}
}
