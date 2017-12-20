package com.amazonaws.lambda.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
// http://www.geeksforgeeks.org/find-winner-election-votes-represented-candidate-names/
public class Hash {
	// Driver code
    public static void main(String[] args)
    {
       String[] votes = { "john", "johnny", "jackie",
                         "johnny", "john", "jackie",
                         "jamie", "jamie", "john",
                         "johnny", "jamie", "johnny",
                         "john" };
 
       findWinner(votes);
    }

	private static void findWinner(String[] votes) {
		Map<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < votes.length; i++) {
			if(hashMap.get(votes[i]) == null) {
				hashMap.put(votes[i], 1);
			} else {
				Integer occurrence = hashMap.get(votes[i]);
				hashMap.put(votes[i], occurrence + 1);
			}
		}
		Integer max = 0;
		String winner = null;
		for(Entry<String, Integer> entry: hashMap.entrySet()) {
			
			if (entry.getValue().equals(max)) {
				if (winner.compareTo(entry.getKey()) > 0) {
					winner = entry.getKey();
				}
			}
			if (entry.getValue() > max) {
				winner = entry.getKey();
				max = entry.getValue();
			}
			
		}
		System.out.println(winner);
	}
}
