package com.canPlaceFlowers;
import java.util.*;

/*You have a long flowerbed in which some of the plots are planted, 
and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means 
empty and 1 means not empty, and an integer n, return if n new flowers can 
be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false*/

public class E605_Can_Place_Flowers {

	public static void main(String[] args) {
		int[] input = {1,0,1,0,0,1,0,0,0,0,0,1};//{1,0,0,0,1};
        boolean output = canPlaceFlowers(input, 2);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		
		for(int i = 0; i < flowerbed.length; i++) {
			if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) 
					&& (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
			}
			if(count >= n) return true;
		}
		
		return false;
	}

}
