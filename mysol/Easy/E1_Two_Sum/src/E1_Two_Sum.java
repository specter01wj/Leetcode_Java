import java.util.*;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

public class E1_Two_Sum {

	public static void main(String[] args) {
		int[] input = {1, 3, 5, 11, 13};
        int[] output = twoSum(input, 18);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    用一个hashmap来记录，key记录target-numbers[i]的值，value记录numbers[i]的i的值，如果碰到一个
    numbers[j]在hashmap中存在，那么说明前面的某个numbers[i]和numbers[j]的和为target，i和j即为答案
    */
	
	/*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
         numbers=[2, 7, 11, 15],  target=9
         return [1, 2]
     */
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < numbers.length; i++) {
			if(map.get(numbers[i]) != null) {
				int[] result = {map.get(numbers[i]), i};
				return result;
			}
			map.put(target - numbers[i], i);
		}
		
		int[] result = {};
		return result;
	}

}
