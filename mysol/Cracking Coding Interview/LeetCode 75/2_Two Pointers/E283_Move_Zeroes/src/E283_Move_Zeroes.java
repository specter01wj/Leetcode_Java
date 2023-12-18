import java.util.*;

/*Given an array nums, write a function to move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

public class E283_Move_Zeroes {

	public static void main(String[] args) {
		int[] input = {0,1,0,3,12};
        int[] output = moveZeroes(input);
//		moveZeroes(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    双指针，left代表新数组，right代表老数组
    */
	
	/*
     * @param nums: an integer array
     * @return nothing, do this in-place
     */
	public static int[] moveZeroes(int[] nums) {
		int left = 0, right = 0;
		int[] result = nums.clone();
		
		while(right < nums.length) {
			if(result[right] != 0) {
				int temp = result[left];
				result[left] = result[right];
				result[right] = temp;
				left++;
			}
			right++;
		}
		
		return result;
	}

  public static void moveZeroes_2(int[] nums) {
      // Initialize a pointer for the next position to place a non-zero number
      int insertPos = 0;

      // Traverse the array, moving non-zero numbers to the front
      for (int num : nums) {
          if (num != 0) {
              nums[insertPos++] = num;
          }
      }

      // Fill the remaining array with zeroes
      while (insertPos < nums.length) {
          nums[insertPos++] = 0;
      } 
  }

}
