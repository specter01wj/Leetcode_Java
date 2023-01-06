package com.maximumUnitsonaTruck;
import java.util.*;

/*
You are assigned to put some amount of boxes onto one truck. 
You are given a 2D array boxTypes, 
where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

	.numberOfBoxesi is the number of boxes of type i.
	.numberOfUnitsPerBoxi is the number of units in each box of the type i.

You are also given an integer truckSize, which is the maximum number of boxes 
that can be put on the truck. You can choose any boxes to put on the truck 
as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.


Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.

Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91
*/

public class E1710_Maximum_Units_on_a_Truck {

	public static void main(String[] args) {
		int[][] input = {{1,3},{2,2},{3,1}};
		int truckSize = 4;
		int output = maximumUnits(input, truckSize);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int boxes = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            } else {
                boxes += truckSize * box[1];
                return boxes;
            }
        }
        return boxes;
    }

}
