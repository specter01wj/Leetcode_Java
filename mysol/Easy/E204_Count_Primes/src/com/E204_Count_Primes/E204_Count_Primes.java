package com.E204_Count_Primes;

import java.util.*;

/*Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.*/

public class E204_Count_Primes {

	public static void main(String[] args) {
		int input = 25;
        int output = countPrimes(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    一种比较好的质数筛选方法：埃拉托斯特尼筛法
	然后定义一个boolean数组记录
	
	详细列出算法如下：
	列出2以后的所有序列：
	2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
	标出序列中的第一个素数，也就是2，序列变成：
	2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
	将剩下序列中，划掉2的倍数，序列变成：
	2 3 5 7 9 11 13 15 17 19 21 23 25
	如果现在这个序列中最大数小于最后一个标出的素数的平方，那么剩下的序列中所有的数都是素数，否则回到第二步。
	本例中，因为25大于2的平方，我们返回第二步：
	剩下的序列中第一个素数是3，将主序列中3的倍数划掉，主序列变成：
	2 3 5 7 11 13 17 19 23 25
	我们得到的素数有：2，3
	25仍然大于3的平方，所以我们还要返回第二步：
	现在序列中第一个素数是5，同样将序列中5的倍数划掉，主序列成了：
	2 3 5 7 11 13 17 19 23
	我们得到的素数有：2，3，5 。
	因为23小于5的平方，跳出循环.
	结论：2到25之间的素数是：2 3 5 7 11 13 17 19 23。
    */
	
	/*
     * @param n: a integer
     * @return: return a integer
     */
	public static int countPrimes(int n) {
		if(n <= 1) {
			return 0;
		}
		
		int res = 0;
		List<Integer> arrList = new ArrayList<>();
		boolean[] notPrime = new boolean[n];
		
		for(int i = 2; i < n; i++) {
			if(notPrime[i] == false) {
				res++;
				arrList.add(i);
				for(int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		
		return res;
		
	}

}
