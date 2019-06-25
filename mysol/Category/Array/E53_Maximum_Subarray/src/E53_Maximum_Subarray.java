import java.util.*;

/*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

public class E53_Maximum_Subarray {

	public static void main(String[] args) {
		int[] input = {7,1,5,3,6,4};//{7,6,4,3,1};
        int output = maxSubArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Greedy
    max记录全局最大值，sum记录区间和，如果当前sum>0，那么可以继续和后面的数求和，否则就从0开始
    */
	
	/*
     * @param prices: a list of integers
     * @return: find a largest sum
     */
	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		
		
		return max;
	}

}
