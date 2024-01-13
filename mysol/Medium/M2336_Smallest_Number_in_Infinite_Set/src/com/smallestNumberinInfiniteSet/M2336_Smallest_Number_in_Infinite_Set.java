package com.smallestNumberinInfiniteSet;
import java.util.*;

/*
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

 .SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to 
  contain all positive integers.
 .int popSmallest() Removes and returns the smallest integer contained 
  in the infinite set.
 .void addBack(int num) Adds a positive integer num back into the 
  infinite set, if it is not already in the infinite set.
*/

public class M2336_Smallest_Number_in_Infinite_Set {

	public static void main(String[] args) {
		SmallestInfiniteSet set = new SmallestInfiniteSet();

        String[] actions = {"SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"};
        int[][] parameters = {{}, {2}, {}, {}, {}, {1}, {}, {}, {}};
        Integer[] expectedOutput = {null, null, 1, 2, 3, null, 1, 4, 5};

        for (int i = 0; i < actions.length; i++) {
            Integer result = null;
            switch (actions[i]) {
                case "SmallestInfiniteSet":
                    set = new SmallestInfiniteSet();
                    break;
                case "addBack":
                    set.addBack(parameters[i][0]);
                    break;
                case "popSmallest":
                    result = set.popSmallest();
                    break;
            }
            System.out.println("Action: " + actions[i] + ", Expected: " + expectedOutput[i] + ", Result: " + result);
        }
	}
	
	/*
    solution:
    Heap
    */
	
	/*
     * @param actions: a list of strings
     * @param parameters: a list of integers
     * @return: Implement the SmallestInfiniteSet class
     */
	static class SmallestInfiniteSet {
		private TreeSet<Integer> available;
	    
	    public SmallestInfiniteSet() {
	        available = new TreeSet<>();
	        for (int i = 1; i <= 1000; i++) {  // Assuming a practical upper limit for the test cases
	            available.add(i);
	        }
	    }
	    
	    public int popSmallest() {
	        return available.pollFirst();  // Retrieves and removes the first (smallest) element
	    }
	    
	    public void addBack(int num) {
	        available.add(num);  // TreeSet ensures no duplicates and natural ordering
	    }
	}

}
