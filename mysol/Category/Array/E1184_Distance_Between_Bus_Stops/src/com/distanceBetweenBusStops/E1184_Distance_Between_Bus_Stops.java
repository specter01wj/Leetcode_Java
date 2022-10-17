package com.distanceBetweenBusStops;
import java.util.*;

/*
A bus has n stops numbered from 0 to n - 1 that form a circle. 
We know the distance between all pairs of neighboring stops where 
distance[i] is the distance between the stops number i and (i + 1) % n.

The bus goes along both directions i.e. clockwise and counterclockwise.

Return the shortest distance between the given start and destination stops.


Example 1:

Input: distance = [1,2,3,4], start = 0, destination = 1
Output: 1
Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 

Example 2:

Input: distance = [1,2,3,4], start = 0, destination = 2
Output: 3
Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 

Example 3:

Input: distance = [1,2,3,4], start = 0, destination = 3
Output: 4
Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
*/

public class E1184_Distance_Between_Bus_Stops {

	public static void main(String[] args) {
		int[] distance = {1,2,3,4};
		int start = 0, destination = 3;
		int output = distanceBetweenBusStops(distance, start, destination);
        System.out.println("input: " + Arrays.toString(distance) + "\noutput: " + (output));
	}
	
	
	public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;;
        }
        int res = 0, total = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                res += distance[i];
            }
            total += distance[i];
        }
        return Math.min(res, total - res);
    }

}
