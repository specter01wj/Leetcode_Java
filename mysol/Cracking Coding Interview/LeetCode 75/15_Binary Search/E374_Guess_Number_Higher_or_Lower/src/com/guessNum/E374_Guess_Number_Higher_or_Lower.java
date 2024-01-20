package com.guessNum;
import java.util.*;

/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example :

Input: n = 10, pick = 6
Output: 6*/

public class E374_Guess_Number_Higher_or_Lower {

	public static void main(String[] args) {
		int input = 11;
        int output = guessNumber(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    采用二分的方法可以很快的找到答案，需要注意在取mid的时候不能(l + r) / 2， 
    建议 mid = l + (r - l) / 2，防止超出数据范围。
    */
	
	/*
     * @param n an integer
     * @return the number you guess
     */
	public static int guessNumber(int n) {
		int l = 1, r = n;
		
		while(l <= r) {
			int mid = l + (r - l) / 2;
			int res = GitRepo.guess(mid);
			if(res == 0) {
				return mid;
			}
			if(res == -1) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static class GitRepo {
		public static int guess(int k) {
			if(k == 6) {
				return 0;
			}
			if(k < 6) {
				return -1;
			} else {
				return 1;
			}
		};
	}

}
