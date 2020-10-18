package com.gimslab.algorithms;

import static java.util.Arrays.asList;

import java.util.Vector;

public class PowerSetWithDp {

	public static void main(String[] args) {
		Set set = new Set(1, 2, 3);
		PSet subs = powerset(set);
		System.out.println(set);
		System.out.println(subs);
	}

	private static PSet powerset(Set set) {
		PSet result = new PSet();
		for (Integer item : set) {
			int resultSize = result.size();
			for (int i = 0; i < resultSize; i++)
				result.add(
						result.get(i).copy().append(item));
			result.add(new Set(item));
		}
		return result;
	}

	static class Set extends Vector<Integer> {
		Set() {
			super();
		}

		Set(Integer... items) {
			super();
			add(items);
		}

		Set(Set set) {
			super(set);
		}

		void add(Integer... items) {
			super.addAll(asList(items));
		}

		Set copy() {
			return new Set(this);
		}

		Set append(Integer item) {
			super.add(item);
			return this;
		}
	}

	static class PSet extends Vector<Set> {
		public PSet() {
			super();
		}
	}
}
