package find_pair_for_the_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairForTheSum {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 7, 9 };
		int targetSum = 10;
		
		System.out.println("arr = " + Arrays.toString(arr));
		System.out.println("targetSum = " + targetSum);

		findPair(arr, targetSum).forEach(
									System.out::println);
	}

	private static List<Pair> findPair(int[] arr, int targetSum) {

		List<Pair> results = new ArrayList<>();
		Map<Integer, Integer> mapForIndex = makeIndexMapFrom(arr);
		for (int i = 0; i < arr.length; i++) {
			int left = arr[i];
			int right = targetSum - left;
			Integer rightIndex = mapForIndex.get(right);
			if (rightIndex != null && i != rightIndex)
				results.add(Pair.newPair(left, right));
		}
		return results;
	}

	private static Map<Integer, Integer> makeIndexMapFrom(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
			map.put(arr[i], i);
		return map;
	}

	private static class Pair {
		int a;
		int b;

		private static Pair newPair(int a, int b) {
			Pair p = new Pair();
			p.a = a;
			p.b = b;
			return p;
		}

		@Override
		public String toString() {
			return a + "," + b;
		}
	}
}
