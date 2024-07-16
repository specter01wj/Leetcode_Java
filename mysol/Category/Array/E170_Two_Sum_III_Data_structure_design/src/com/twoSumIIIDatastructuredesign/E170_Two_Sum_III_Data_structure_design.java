package com.twoSumIIIDatastructuredesign;
import java.util.*;

public class E170_Two_Sum_III_Data_structure_design {

	public static void main(String[] args) {
		E170_Two_Sum_III_Data_structure_design twoSum = new E170_Two_Sum_III_Data_structure_design();
        twoSum.add(1);   // [] --> [1]
        twoSum.add(3);   // [1] --> [1, 3]
        twoSum.add(5);   // [1, 3] --> [1, 3, 5]
        
        System.out.println("input: " + (twoSum) + "\noutput: ");
        System.out.println(twoSum.find(4));  // 1 + 3 = 4, return true
        System.out.println(twoSum.find(7)); // return false
	}
	
	
	private Map<Integer, Integer> numCounts;
    
    public E170_Two_Sum_III_Data_structure_design() {
        numCounts = new HashMap<>();
    }
    
    public void add(int number) {
        numCounts.put(number, numCounts.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (Integer key : numCounts.keySet()) {
            int complement = value - key;
            if (complement == key) {
                if (numCounts.get(key) > 1) {
                    return true;
                }
            } else {
                if (numCounts.containsKey(complement)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Two_Sum:{" +
                "numCounts=" + numCounts +
                '}';
    }

}
