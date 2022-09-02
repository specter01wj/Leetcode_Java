package com.dIStringMatch;
import java.util.*;

/*
A permutation perm of n + 1 integers of all the integers in the 
range [0, n] can be represented as a string s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].

Given a string s, reconstruct the permutation perm and return it. 
If there are multiple valid permutations perm, return any of them.


Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]

Example 2:

Input: s = "III"
Output: [0,1,2,3]

Example 3:

Input: s = "DDI"
Output: [3,2,0,1]
*/

public class E942_DI_String_Match {

	public static void main(String[] args) {
		String input = "IDID";
        int[] output = diStringMatch(input);
        System.out.println("input: " + (input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    只需要证明，对于任何 > 或者 < , 算法的规则都能满足。 △N = max-min; 
    由于每次遇到一个符号，△N-1。 当符号为“ <   <   <”: max--可以保证符号的正确性。 
    当符号为“ >   >   >”: min++可以保住符号的正确性。 
    当符号为“ ……<   >   < ":  任意时刻max和min开始比较，是否满足 min < max? 
    由于符号的数量为N，最开始△N = N。
    由于至少出现一对大于号和小于号 , min(△N)= 1，仍然满足min < max。 
    因为每一位对应的数字只有两种情况：比右边所有数都大，或者都小。
    那么我们可以设定两个值，初始的话：low = 0，high = N。
    这样，从左开始遍历字符串，碰见一个字符，如果是‘I’，那么就直接赋值low，同时low++。
    这样，‘I’右边所有的数，一定是都比这个位置大的。因为此时low>ai，同时high > low。 
    反而言之，碰见‘D’，直接赋值hight，同时high--。这样所有的数就一定比这个小了。
    在O(n)的时间复杂度下就能构造出答案数组。
    */
	
	/**
     * @param nums: a String
     * @return: an Array
     */
	public static int[] diStringMatch(String s) {
		int max = s.length();
        int len = s.length();
        int min = 0;
        int[] ans = new int[max+1];
        
        for (int i = 0;i < len;i++) {
            char c = s.charAt(i);
            if(c == 'D'){
                ans[i] = max--;
            }
            else{
                ans[i] = min++;
            }
        }
        ans[len] = min;
        
        return ans;
	}

}
