package com.assignCookies;
import java.util.*;

/*Assume you are an awesome parent and want to 
 give your children some cookies. But, you should 
 give each child at most one cookie.

Each child i has a greed factor g[i], which is the 
minimum size of a cookie that the child will be content with; 
and each cookie j has a size s[j]. If s[j] >= g[i], 
we can assign the cookie j to the child i, and the child 
i will be content. Your goal is to maximize the number of 
your content children and output the maximum number.

 

Example 1:

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. 
The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, 
you could only make the child whose greed factor is 1 content.
You need to output 1.*/

public class E455_Assign_Cookies {

	public static void main(String[] args) {
		int[] g = {1,2,3}, s = {1,1};
        int output = findContentChildren(g, s);
        System.out.println("input G: " + Arrays.toString(g) + " input S: " + Arrays.toString(s) 
        					+ "\noutput: " + (output));
	}
	
	/**
     * @param g: children's greed factor
     * @param s: cookie's size
     * @return: the maximum number
     */
	public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; count < g.length && i < s.length; i++) {
            if (g[count] <= s[i]){
                count++;
            }
        }
        return count;
    }

}
