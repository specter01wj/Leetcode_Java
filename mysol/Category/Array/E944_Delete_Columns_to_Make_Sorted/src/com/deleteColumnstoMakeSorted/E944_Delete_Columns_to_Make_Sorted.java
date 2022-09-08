package com.deleteColumnstoMakeSorted;
import java.util.*;

/*
You are given an array of n strings strs, all of the same length.

The strings can be arranged such that there is one on each line, making a grid. 
For example, strs = ["abc", "bce", "cae"] can be arranged as:

abc
bce
cae

You want to delete the columns that are not sorted lexicographically. 
In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') 
are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

Return the number of columns that you will delete.


Example 1:

Input: strs = ["cba","daf","ghi"]
Output: 1
Explanation: The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to 
delete 1 column.

Example 2:

Input: strs = ["a","b"]
Output: 0
Explanation: The grid looks as follows:
  a
  b
Column 0 is the only column and is sorted, so you will not delete any columns.

Example 3:

Input: strs = ["zyx","wvu","tsr"]
Output: 3
Explanation: The grid looks as follows:
  zyx
  wvu
  tsr
All 3 columns are not sorted, so you will delete all 3.
*/

public class E944_Delete_Columns_to_Make_Sorted {

	public static void main(String[] args) {
		String[] input = {"cba","daf","ghi"};
        int output = minDeletionSize(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int minDeletionSize(String[] strs) {
		if (strs.length == 0) {
            return 0;
        }
		
        int result = 0;
        for (int c = 0; c < strs[0].length(); ++c) {
            for (int i = 0; i < strs.length - 1; ++i) {
                if (strs[i].charAt(c) > strs[i+1].charAt(c)) {
                    ++result; 
                    break;
                }
            }
        }
        
        return result;
	}

}
