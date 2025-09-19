package com.hashing;
import java.util.*;

public class Ch3_hashing {

	public static void main(String[] args) {
		Ch3_hashing solution = new Ch3_hashing();
		solution.interfaceGuide();
	}
	
	public void interfaceGuide() {
		// Declaration: Java supports multiple implementations, but we will using
		// the Map interface with the HashMap implementation. Specify the data type
		// of the keys and values
//		Map<Integer, Integer> hashMap = new HashMap<>();

		// If you want to initialize it with some key value pairs, use the following syntax:
		Map<Integer, Integer> hashMap = new HashMap<>() {{
		    put(1, 2);
		    put(5, 3);
		    put(7, 2);
		}};

		// Checking if a key exists: use .containsKey()
//		hashMap.containsKey(1); // true
//		hashMap.containsKey(9); // false
		System.out.println("Contains key 1? " + hashMap.containsKey(1)); // true
        System.out.println("Contains key 9? " + hashMap.containsKey(9)); // false

		// Accessing a value given a key: use .get()
		hashMap.get(5); // 3

		// Adding or updating a key: use .put()
		// If the key already exists, the value will be updated
		hashMap.put(5, 6);

		// If the key doesn't exist yet, the key value pair will be inserted
		hashMap.put(9, 15);

		// Deleting a key: use .remove()
		hashMap.remove(9);

		// Get size
//		hashMap.size(); // 3
		System.out.println("Size of map: " + hashMap.size()); // 3

		// Iterate over keys: use .keySet()
		System.out.println("Keys:");
		for (int key: hashMap.keySet()) {
		    System.out.println(key);
		}

		// Iterate over values: use .values()
		System.out.println("Values:");
		for (int val: hashMap.values()) {
		    System.out.println(val);
		}
	}

}
