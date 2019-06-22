import java.util.*;

/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/

public class M229_Majority_Element_II {

	public static void main(String[] args) {
		int[] input = {1,1,1,3,3,2,2,2};
		List<Integer> output = majorityElement(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Using Extra Array
	Algorithm
	We use an extra array in which we place every element of the array 
	at its correct position i.e. the number at index ii in the original 
	array is placed at the index (i+k)%(length of array)(i+k). 
	Then, we copy the new array to the original one.
    */
	
	/*
     * @param nums: a list of integers
     * @return: List of majority number
     */
	public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i : nums) {
            if (count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            } else {
                count.put(i, 1);
            }
        
            if (count.get(i) > nums.length / 3 && !result.contains(i)) {
                result.add(i);
            }
        }
        
        
        return result;
    }

}
