package com.finding3DigitEvenNumbers;
import java.util.*;

/*
You are given an integer array digits, where each element is a digit. 
The array may contain duplicates.

You need to find all the unique integers that follow the given requirements:

	.The integer consists of the concatenation of three elements from digits in any arbitrary order.
	.The integer does not have leading zeros.
	.The integer is even.

For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.

Return a sorted array of the unique integers.


Example 1:

Input: digits = [2,1,3,0]
Output: [102,120,130,132,210,230,302,310,312,320]
Explanation: All the possible integers that follow the requirements are in the output array. 
Notice that there are no odd integers or integers with leading zeros.
Example 2:

Input: digits = [2,2,8,8,2]
Output: [222,228,282,288,822,828,882]
Explanation: The same digit can be used as many times as it appears in digits. 
In this example, the digit 8 is used twice each time in 288, 828, and 882. 
Example 3:

Input: digits = [3,7,5]
Output: []
Explanation: No even integers can be formed using the given digits.
*/

public class E2094_Finding_3Digit_Even_Numbers {

	public static void main(String[] args) {
		int[] input = {2,1,3,0};
		int[] output = findEvenNumbers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    We want unique numbers of 3 digits only that too only even.  so first we gather the frequency 
    of all the digits we have, then we iterate from 100 to 999 (all possible even 3 digit numbers).  
	for example, iterating and at 104  so we will see that if we have  digits 1,0,4 in our database 
	if yes then we can make this number from our available digits given to us.
    */
	
	/*
     * @param digits: a list of integers
     * @return: a sorted array of the unique integers
     */
	public static int[] findEvenNumbers(int[] digits) {
        int [] map = new int[10];
        
        for (int i = 0;i < digits.length;i++) {
            map[digits[i]]++;
        }
        
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 100;i <= 999;i = i + 2) {
            int num = i;
            int [] freq = new int[10];
            while (num > 0) {
                int rem = num % 10;
                freq[rem]++;
                num = num / 10;
            }
            boolean res = findans(freq, map);
            if (res) {
                arr.add(i);
            }
        }
        
        int [] ans = new int[arr.size()];
        for (int i = 0;i < arr.size();i++) {
            ans[i] = arr.get(i);
        }
        
        return ans;
    }

    private static boolean findans(int [] currentNum,int [] database){
        for (int i = 0;i < 10;i++) {
            if (currentNum[i] > database[i]) {
                return false;
            }
        }
        return true;
    }

}
