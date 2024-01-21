package com.kokoEatingBananas;
import java.util.*;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith 
pile has piles[i] bananas. The guards have gone and will come back 
in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, 
she chooses some pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead 
and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the 
bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas 
within h hours.
*/

public class M875_Koko_Eating_Bananas {

	public static void main(String[] args) {
		int[] input = {30,11,23,4,20};
		int h = 5;
		int output = minEatingSpeed(input, h);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int minEatingSpeed(int[] piles, int h) {
        int left = 1; // minimum possible speed
        int right = getMaxBananaPile(piles); // maximum possible speed

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, h)) {
                // If she can eat all bananas at this rate, try a smaller speed
                right = mid;
            } else {
                // Otherwise, she needs a higher speed
                left = mid + 1;
            }
        }
        
        return left;
    }

    private static boolean canEatAll(int[] piles, int speed, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / speed);
        }
        return hours <= h;
    }

    private static int getMaxBananaPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

}
