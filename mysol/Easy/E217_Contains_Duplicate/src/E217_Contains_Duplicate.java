import java.util.*;

/*Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
*/

public class E217_Contains_Duplicate {

	public static void main(String[] args) {
		int[] input = {1,1,1,3,3,4,3,2,4,2};
        boolean output = containsDuplicate(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    使用HashSet判断重复
    */
	
	/**
     * @param nums: the given array
     * @return: if any value appears at least twice in the array
     */
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		
		for(int x : nums) {
			if(set.contains(x)) {
				return true;
			}
			set.add(x);
		}
		
		return false;
	}

}
