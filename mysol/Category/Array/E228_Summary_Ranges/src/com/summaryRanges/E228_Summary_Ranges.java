package com.summaryRanges;
import java.util.*;

/*You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers 
in the array exactly. That is, each element of nums is covered by 
exactly one of the ranges, and there is no integer x such that 
x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
Example 3:

Input: nums = []
Output: []
Example 4:

Input: nums = [-1]
Output: ["-1"]
Example 5:

Input: nums = [0]
Output: ["0"]*/

public class E228_Summary_Ranges {

	public static void main(String[] args) {
		int[] input = {0,2,3,4,6,8,9};//{0,1,2,4,5,7};
		List<String> output = summaryRanges(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	public static List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList();
		if(nums.length == 1) {
			list.add(nums[0] + "");
			return list;
		}
		
		for(int i = 0; i < nums.length; i++) {
			int a = nums[i];
			while(i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
				i++;
			}
			if(a != nums[i]) {
				list.add(a + "->" + nums[i]);
			} else {
				list.add(a + "");
			}
		}
		
		return list;
	}

}
