package com.checkArrayFormationThroughConcatenation;
import java.util.*;

/*
You are given an array of distinct integers arr and an array of integer arrays pieces, 
where the integers in pieces are distinct. Your goal is to form arr by concatenating 
the arrays in pieces in any order. However, you are not allowed to reorder the integers 
in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.


Example 1:

Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]

Example 2:

Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].

Example 3:

Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
Output: true
Explanation: Concatenate [91] then [4,64] then [78]
*/

public class E1640_Check_Array_Formation_Through_Concatenation {

	public static void main(String[] args) {
		int[] input = {91,4,64,78};
		int[][] pieces = {{78},{4,64},{91}};
		boolean output = canFormArray(input, pieces);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,int[]> hm = new HashMap();
        for(int[] list:pieces) {
            hm.put(list[0],list);
        }
        
        int index = 0;
        while(index<arr.length){
            if(!hm.containsKey(arr[index])) {
                return false;
            }
            
            int[] list = hm.get(arr[index]);
            for(int val:list){
                if(index>=arr.length || val!=arr[index]) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }

}
