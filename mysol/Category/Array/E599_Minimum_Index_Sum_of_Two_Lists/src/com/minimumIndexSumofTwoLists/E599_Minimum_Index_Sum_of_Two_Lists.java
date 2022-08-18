package com.minimumIndexSumofTwoLists;
import java.util.*;

/*
Suppose Andy and Doris want to choose a restaurant for dinner, 
and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least 
list index sum. If there is a choice tie between answers, output all of 
them with no order requirement. You could assume there always exists an answer.


Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], 
list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], 
list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index 
sum is "Shogun" with index sum 1 (0+1).
*/

public class E599_Minimum_Index_Sum_of_Two_Lists {

	public static void main(String[] args) {
		String[] input1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] input2 = {"KFC","Shogun","Burger King"};
        String[] output = findRestaurant(input1, input2);
        System.out.println("input1: " + Arrays.toString(input1) +
        		"\ninput2: " + Arrays.toString(input2) + 
        		"\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    直接对比两个列表中的某个字符串是否相等，再同时统计最小索引和即可。
    */
	
	/**
     * @param list1: a list of strings
     * @param list2: a list of strings
     * @return: the common interest with the least list index sum
     */
	public static String[] findRestaurant(String[] list1, String[] list2) {
		int ans = list1.length + list2.length;
		
        ArrayList<String> s = new ArrayList<>();
        
        for(int i = 0; i < list1.length; i++) {
            for(int j = 0; j < list2.length; j++) {
                if(list1[i].equals(list2[j])) {
                    if(i + j < ans) {
                        s = new ArrayList<>();
                        ans = i + j;
                        s.add(list1[i]);
                    }
                    else if(i + j == ans) {
                    	s.add(list1[i]);
                    }
                }
            }
        }
        return s.toArray(new String[s.size()]);
	}

}
