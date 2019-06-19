import java.util.*;

/*Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
*/

public class E26_Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		int[] input = {0,0,1,1,1,2,2,3,3,4};
        int output = removeDuplicates(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    由于有序，所以相同的数字排在一起。
	用一个游标变量指向已经去重的部分的下一个空位，只要a[i] != a[i-1],就将a[i]填入之前的空位。
    */
	
	/*
     * @param nums: An ineger array
     * @return: An integer
    */
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int i = 0;
		for(int j = 1; j < nums.length; j++) {
			if(nums[j] != nums[i]) {
				nums[++i] = nums[j];
			}
		}
		
		return i + 1;
	}

}
