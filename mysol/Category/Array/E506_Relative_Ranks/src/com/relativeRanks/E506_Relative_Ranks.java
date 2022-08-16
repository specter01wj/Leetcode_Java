package com.relativeRanks;
import java.util.*;

/*You are given an integer array score of size n, where score[i] is 
 the score of the ith athlete in a competition. 
 All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place 
athlete has the highest score, the 2nd place athlete has the 
2nd highest score, and so on. The placement of each athlete 
determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their 
placement number (i.e., the xth place athlete's rank is "x").

Return an array answer of size n where answer[i] is the rank of the ith athlete.

Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].

Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
*/

public class E506_Relative_Ranks {

	public static void main(String[] args) {
		int[] input = {10,3,8,9,4};
		System.out.println("input: " + Arrays.toString(input));
        String[] output = findRelativeRanks(input);
        System.out.println("Output: " + Arrays.toString(output));
	}
	
	
	/*
	 * solution:
	使用hashmap记录好元素的原始位置，排序之后按原来元素的位置存放比赛排名。
	*/
	
	/**
     * @param nums: List[int]
     * @return: return List[str]
     */
	public static String[] findRelativeRanks(int[] nums) {
		HashMap<Integer, Integer> score = new HashMap();
		
		for(int i = 0; i < nums.length; i++) {
			score.put(nums[i], i);
		}
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length/2; i++) {
			int temp = nums[i];
			nums[i] = nums[nums.length - i - 1];
			nums[nums.length - i - 1] = temp;
		}
		
		String[] answer = new String[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			String res = String.valueOf(i + 1);
			if(i == 0) res = "Gold Medal";
			if(i == 1) res = "Silver Medal";
			if(i == 2) res = "Bronze Medal";
			answer[score.get(nums[i])] = res;
		}
		
		return answer;
	}

}
