package com.howManyApplesCanYouPutintotheBasket;
import java.util.*;

/*
You have some apples and a basket that can carry up to 5000 units of weight.

Given an integer array weight where weight[i] is the weight of the ith apple, 
return the maximum number of apples you can put in the basket.
*/

public class E1196_How_Many_Apples_Can_You_Put_into_the_Basket {

	public static void main(String[] args) {
		int[] input = {3,0,1,1,9,7};
		int output = countGoodTriplets(input, 7, 2, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    count good triplets
    */
	
	/*
     * @param weight: a list of integers
     * @return: the maximum number of apples you can put in the basket
     */
	public int maxNumberOfApples(int[] weight) {
        // Sort the weights array to try and add lighter apples first
        Arrays.sort(weight);
        
        int totalWeight = 0;
        int count = 0;
        
        // Iterate through the sorted weights
        for (int i = 0; i < weight.length; i++) {
            totalWeight += weight[i];
            if (totalWeight > 5000) {
                break;
            }
            count++;
        }
        
        return count;
    }

}
