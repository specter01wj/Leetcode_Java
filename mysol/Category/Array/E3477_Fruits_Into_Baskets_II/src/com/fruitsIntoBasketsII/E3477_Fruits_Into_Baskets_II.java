package com.fruitsIntoBasketsII;
import java.util.*;

/*
You are given two arrays of integers, fruits and baskets, each of length n, 
where fruits[i] represents the quantity of the ith type of fruit, and 
baskets[j] represents the capacity of the jth basket.

From left to right, place the fruits according to these rules:

	. Each fruit type must be placed in the leftmost available basket with 
		a capacity greater than or equal to the quantity of that fruit type.
	. Each basket can hold only one type of fruit.
	. If a fruit type cannot be placed in any basket, it remains unplaced.

Return the number of fruit types that remain unplaced after all possible 
allocations are made.
*/

public class E3477_Fruits_Into_Baskets_II {

	public static void main(String[] args) {
		E3477_Fruits_Into_Baskets_II solution = new E3477_Fruits_Into_Baskets_II();
		int[] fruits = {4,2,5}, baskets = {3,5,4};
		int[] basketsCopy = Arrays.copyOf(baskets, baskets.length);
		int output = solution.numOfUnplacedFruits(fruits, basketsCopy);
        System.out.println("fruits: " + Arrays.toString(fruits) 
        	+ "; baskets: " + Arrays.toString(baskets) 
        	+ "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate over the fruits from left to right.
	2. For each fruit:
		. Try to place it in the leftmost basket whose capacity is greater than or equal to the fruit’s quantity.
		. Once placed, mark that basket as used (e.g., with a sentinel like -1).
	3. If a fruit can’t be placed, count it as unplaced.
	4. Return the total number of unplaced fruit types.
    */
	
	/*
     * @param fruits: a list of integers
     * @param baskets: a list of integers
     * @return: the number of fruit types that remain unplaced after all possible allocations are made
     */
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int unplacedCount = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;

            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruits[i]) {
                    // Place the fruit and mark the basket as used
                    baskets[j] = -1;
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                unplacedCount++;
            }
        }

        return unplacedCount;
    }

}
