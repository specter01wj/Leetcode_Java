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
		int[] input = {1,2,3,4,5,6,7};
        int[] output = rotate(input, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> counts = countNums(nums);
	}

}
