package com.spm.firstBadVersion;
import java.util.*;

/*You are a product manager and currently leading a team to develop a new product. 
 Unfortunately, the latest version of your product fails the quality check. 
 Since each version is developed based on the previous version, all the versions 
 after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. You should minimize the number of 
calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
*/

public class E278_First_Bad_Version {

	public static void main(String[] args) {
		int input = 5;
        int output = firstBadVersion(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    算法：二分

	假设第k个版本为第一个错误版本，那么1---n个版本分为1---k-1为正确版本，k---n为错误版本，
	
	我们需要以尽量少的次数去找到这个k，显然我们如果一个个找过去的平均复杂度是O(n)
	
	那么我们可以考虑用二分来找到这个k,二分的复杂度为O(logn)
	
	二分[1,n]这个区间
	判断isBadVersion（mid）
	如果为false 说明第一个错误版本在mid的右边，令 left = mid
	反之则在mid左边，令 right = mid
	缩小判断范围，当left+1>=right的时候结束二分
	最后再次判断下isBadVersion（left）,如果是错误版本的话返回left,反之返回right
	复杂度分析
	
	时间复杂度O(logn)
	二分的时间复杂度
	空间复杂度O(1)
	无需额外空间
    */
	
	/*
     * @param prices: a list of integers
     * @return: find a maximum profit
     */
	public static int firstBadVersion(int n) {
		int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (GitRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
            
        if (GitRepo.isBadVersion(start)) {
            return start;
        }
        return end;
	}
	
	public static class GitRepo {
		public static boolean isBadVersion(int k) {
			if(k == 4) {
				return true;
			}
			return false;
		};
	}

}


