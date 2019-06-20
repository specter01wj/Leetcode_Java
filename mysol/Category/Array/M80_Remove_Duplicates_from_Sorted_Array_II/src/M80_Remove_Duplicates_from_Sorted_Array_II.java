import java.util.*;

/*Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
*/

public class M80_Remove_Duplicates_from_Sorted_Array_II {

	public static void main(String[] args) {
		int[] input = {0,0,1,1,1,1,2,3,3};
        int output = removeDuplicates2(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    从重复的第三个开始删除即可
    */
	
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
	public static int removeDuplicates2(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int index = 0, count = 1;
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[index]) {
				if(count < 2) {
					nums[++index] = nums[i];
					count++;
				}
			} else {
				nums[++index] = nums[i];
				count = 1;
			}
		}
		
		return index + 1;
	}

}
