import java.util.*;

/*Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*/

public class E189_Rotate_Array {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7};
        int[] output = rotate(input, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
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
	
	/**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
	public static int[] rotate(int[] nums, int k) {
		int[] arr = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			arr[(i + k) % nums.length] = nums[i];
		}
		
		return arr;
	}
	

}
