import java.util.*;

/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

public class E169_Majority_Element {

	public static void main(String[] args) {
		int[] input = {7,2,5,7,5,2,7,8,7};//{2,2,1,1,1,2,2};
        int output = majorityElement(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    We know that the majority element occurs more than n/2 times, and a HashMap 
    allows us to count element occurrences efficiently.
    
    Algorithm
    We can use a HashMap that maps elements to counts in order to count occurrences 
    in linear time by looping over nums. 
    Then, we simply return the key with maximum value.
    */
	
	/*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> counts = countNums(nums);
		Map.Entry<Integer, Integer> majorityEntry = null;
		
		for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
				majorityEntry = entry;
			}
		}
		
		return majorityEntry.getKey();
	}
	
	private static Map<Integer, Integer> countNums(int[] nums) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		
		for(int num : nums) {
			if(!counts.containsKey(num)) {
				counts.put(num, 1);
			} else {
				counts.put(num, counts.get(num) + 1);
			}
		}
		
		return counts;
	}

}
