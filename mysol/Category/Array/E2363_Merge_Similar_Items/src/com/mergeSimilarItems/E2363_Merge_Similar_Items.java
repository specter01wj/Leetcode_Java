package com.mergeSimilarItems;
import java.util.*;

/*
You are given two 2D integer arrays, items1 and items2, representing two sets of items. 
Each array items has the following properties:

. items[i] = [valuei, weighti] where valuei represents the value and weighti represents 
  the weight of the ith item.
. The value of each item in items is unique.

Return a 2D integer array ret where ret[i] = [valuei, weighti], with weighti being 
the sum of weights of all items with value valuei.
*/

public class E2363_Merge_Similar_Items {

	public static void main(String[] args) {
		int[][] input1 = {{1,1},{4,5},{3,8}}, input2 = {{3,1},{1,5}};
		List<List<Integer>> output = mergeSimilarItems(input1, input2);
        System.out.println("input1: " + Arrays.deepToString(input1) + 
        		"; input2: " + Arrays.deepToString(input2) + "\noutput: " + (output));
	}
	
	
	public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // Step 1: Combine items from both arrays
        List<int[]> combinedItems = new ArrayList<>();
        for (int[] item : items1) {
            combinedItems.add(item);
        }
        for (int[] item : items2) {
            combinedItems.add(item);
        }

        // Step 2: Map values to their summed weights
        Map<Integer, Integer> valueToWeight = new HashMap<>();
        for (int[] item : combinedItems) {
            int value = item[0];
            int weight = item[1];
            valueToWeight.put(value, valueToWeight.getOrDefault(value, 0) + weight);
        }

        // Step 3: Sort the map entries by value
        List<List<Integer>> sortedItems = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : valueToWeight.entrySet()) {
            sortedItems.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        sortedItems.sort(Comparator.comparingInt(a -> a.get(0)));

        // Step 4: Return the sorted list
        return sortedItems;
    }

}
