package com.gimslab.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LRUCache {

	private int capacity;
	private List<Data> list;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.list = new ArrayList<>();
	}

	private String get(String key) {
		// FIXME remove iteration
		for (Data d : list) {
			if (d.key.equals(key)) {
				String value = d.value;
				// FIXME remove iteration
				list.remove(d);
				list.add(new Data(key, value));
				return value;
			}
		}
		return "-1";
	}

	private void put(String k, String v) {
		list.add(new Data(k, v));
		if (list.size() > capacity)
			list.remove(0);
	}

	@Override
	public String toString() {
		return list.toString();
	}

	class Data {
		String key, value;

		public Data(String key, String value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put("1", "1");
		cache.put("2", "2");
		cache.put("3", "3");
		System.out.println(cache);
		System.out.printf("get %s = %s\n", "1", cache.get("1"));
		System.out.printf("get %s = %s\n", "2", cache.get("2"));
		cache.put("4", "4");
		System.out.println(cache);
	}
}
