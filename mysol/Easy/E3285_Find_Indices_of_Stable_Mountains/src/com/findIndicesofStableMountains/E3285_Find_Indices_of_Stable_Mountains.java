package com.findIndicesofStableMountains;
import java.util.*;

/*
There are n mountains in a row, and each mountain has a height. 
You are given an integer array height where height[i] represents 
the height of mountain i, and an integer threshold.

A mountain is called stable if the mountain just before it (if it exists) 
has a height strictly greater than threshold. Note that mountain 0 is not stable.

Return an array containing the indices of all stable mountains in any order.
*/

public class E3285_Find_Indices_of_Stable_Mountains {

	public static void main(String[] args) {
		E3285_Find_Indices_of_Stable_Mountains solution = new E3285_Find_Indices_of_Stable_Mountains();
		int[] input = {1,2,3,4,5};
		int threshold = 2;
		List<Integer> output = solution.stableMountains(input, threshold);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Start from index 1 (since mountain 0 can't be stable).
	2. For each mountain i, we check if the previous mountain height[i - 1] is strictly greater than the threshold.
	3. If so, we add index i to the result list.
    */
	
	/*
     * @param height: a list of integers
     * @param threshold: an integer
     * @return: an array containing the indices of all stable mountains in any order
     */
	public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>();
    
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                result.add(i);
            }
        }
        
        return result;
    }

}
