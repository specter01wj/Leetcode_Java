package com.kthDistinctStringinanArray;
import java.util.*;

/*
A distinct string is a string that is present only once in an array.

Given an array of strings arr, and an integer k, return the kth distinct 
string present in arr. If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.


Example 1:

Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1st, so it is the 1st distinct string.
"a" appears 2nd, so it is the 2nd distinct string.
Since k == 2, "a" is returned. 

Example 2:

Input: arr = ["aaa","aa","a"], k = 1
Output: "aaa"
Explanation:
All strings in arr are distinct, so the 1st string "aaa" is returned.

Example 3:

Input: arr = ["a","b","a"], k = 3
Output: ""
Explanation:
The only distinct string is "b". Since there are fewer than 3 distinct strings, 
we return an empty string "".
*/

public class E2053_Kth_Distinct_String_in_an_Array {

	public static void main(String[] args) {
		String[] input = {"d","b","c","b","c","a"};
		int k = 2;
		String output = kthDistinct(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. in first iteration record the frequencies of each string in the map
	2. in the second iteration if you find a string with frequency 1 then decreese k .
	3. when k ==0 we have found the kth distrinct string.
    */
	
	/*
     * @param arr: a list of strings
     * @param k: an integer
     * @return: the kth distinct string present in arr
     */
	public static String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new HashMap<>();
        
        for (String s : arr) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
		int i = 0;
        for (String s : arr) {
            if (map.get(s) == 1 && ++i == k) {
                return s;
            } 
        }
        return "";
    }

}
