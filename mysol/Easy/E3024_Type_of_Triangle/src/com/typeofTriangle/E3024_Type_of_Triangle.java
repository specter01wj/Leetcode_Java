package com.typeofTriangle;
import java.util.*;

/*
You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.

	. A triangle is called equilateral if it has all sides of equal length.
	. A triangle is called isosceles if it has exactly two sides of equal length.
	. A triangle is called scalene if all its sides are of different lengths.

Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.
*/

public class E3024_Type_of_Triangle {

	public static void main(String[] args) {
		E3024_Type_of_Triangle solution = new E3024_Type_of_Triangle();
		int[] input = {3,4,5};
		String output = solution.triangleType(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Input Validation: Ensure the input array is not null and contains exactly three elements.
	2. Sort the Array: Sorting simplifies the triangle inequality checks.
	3. Triangle Inequality Check: If the sum of the two smaller sides is not greater than the largest side, it cannot form a triangle.
	4. Equilateral Check: All three sides must be equal.
	5. Isosceles Check: Exactly two sides must be equal.
	6. Scalene Check: If none of the above conditions are met, the triangle is scalene.
    */
	
	/*
     * @param nums: a list of integers
     * @return: a string representing the type of triangle
     */
	public String triangleType(int[] nums) {
        // Check if the array is not null and has exactly 3 elements
        if (nums == null || nums.length != 3) {
            return "none";
        }

        // Sort the array to simplify triangle inequality checks
        Arrays.sort(nums);

        // Check if the sides can form a triangle
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }

        // Check for equilateral triangle
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }

        // Check for isosceles triangle
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        }

        // If none of the above, it's a scalene triangle
        return "scalene";
    }

}
