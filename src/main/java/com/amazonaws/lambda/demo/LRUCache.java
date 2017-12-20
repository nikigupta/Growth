package com.amazonaws.lambda.demo;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
	int capacity;
	Map<Integer, Integer> cache;

	LRUCache(int N) {
		capacity = N;
		cache = new LinkedHashMap<>(N, 1.5f, true);
	}
//	SET 94 16 SET 93 87 SET 63 22 SET 60 91 SET 41 27 GET 73 GET 12 GET 68 SET 31 83 GET 24 SET 30 36 GET 23 GET 70 SET 57 94 SET 30 43 SET 20 22 GET 38 GET 25 SET 14 71 GET 92 GET 57 SET 71 63 GET 82 SET 85 26 SET 6 37 GET 30 SET 25 58 SET 46 83 GET 68 GET 65 SET 88 51 GET 77 GET 89 GET 4 SET 100 55 GET 61 GET 69 SET 27 13 GET 95 SET 71 96 GET 79 SET 98 2 GET 18 GET 53 GET 2 GET 87 SET 90 66 GET 20 GET 30 SET 98 18 SET 76 82 SET 68 28 GET 98 SET 66 87 GET 84 SET 29 25 SET 30 33 SET 71 20 GET 9 SET 50 41 GET 24 GET 46 GET 52 SET 80 56 GET 65 GET 42 GET 94 GET 35 GET 25 GET 88 GET 44 SET 66 28 SET 33 37 SET 29 38 SET 75 8 SET 96 59 SET 36 38 SET 29 19 SET 29 12 SET 5 77 SET 14 64 GET 7 GET 5 GET 29 GET 70 SET 97 18 GET 44 

	void set(int x, int y) {
		cache.put(x, y);
//		if (cache.size() > capacity) {
//			cache.remove(cache.entrySet().iterator().next().getKey());
//		}	
		}

	
	int get(int x) {
		if (cache.containsKey(x)) {
			return cache.get(x);
		} else {
			return -1;
		}
	}
	
	public static void main(String args[]) {
		LRUCache lru = new LRUCache(2);
		lru.set(94,16);
		lru.set(2, 3);
		lru.set(1, 5);
		lru.set(4, 5);
		lru.set(6, 7);
		System.out.println(lru.get(94));
	}
}