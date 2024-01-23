package com.combinationSumIII;
import java.util.*;

/*
Find all valid combinations of k numbers that sum up to n such that 
the following conditions are true:

 .Only numbers 1 through 9 are used.
 .Each number is used at most once.

Return a list of all possible valid combinations. The list must not 
contain the same combination twice, and the combinations may be 
returned in any order.
*/

public class M216_Combination_Sum_III {

	public static void main(String[] args) {
		int k = 3, n = 7;
		List<List<Integer>> output = combinationSum3(k, n);
        System.out.println("input: " + (k) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Backtracking
    */
	
	/**
     * @param k: an integer
     * @param n: an integer
     * @return: a list of all possible valid combinations
     */
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int k, int remain, int start) {
        if (remain == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            // Skip if the remaining sum would be negative or if it exceeds the required size
            if (remain - i < 0 || current.size() >= k) {
                break;
            }
            current.add(i);
            backtrack(result, current, k, remain - i, i + 1);
            current.remove(current.size() - 1);
        }
    }

}
