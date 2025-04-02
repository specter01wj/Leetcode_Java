package com.findXSumofAllKLongSubarraysI;
import java.util.*;

/*
You are given an array nums of n integers and two integers k and x.

The x-sum of an array is calculated by the following procedure:

	. Count the occurrences of all elements in the array.
	. Keep only the occurrences of the top x most frequent elements. 
		If two elements have the same number of occurrences, the element 
		with the bigger value is considered more frequent.
	. Calculate the sum of the resulting array.

Note that if an array has less than x distinct elements, its x-sum is 
the sum of the array.

Return an integer array answer of length n - k + 1 where answer[i] is 
the x-sum of the subarray nums[i..i + k - 1].
*/

public class E3318_Find_XSum_of_All_KLong_Subarrays_I {

	public static void main(String[] args) {
		E3318_Find_XSum_of_All_KLong_Subarrays_I solution = new E3318_Find_XSum_of_All_KLong_Subarrays_I();
		int[] input = {1,1,2,2,3,4,2,3};
		int k = 6, x = 2;
		int[] output = solution.findXSum(input, k, x);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    Main Method: findXSum(nums, k, x)
	1. Initialize:
		. n = nums.length
		. result[] as an array of size n - k + 1
		. A HashMap<Integer, Integer> to track element frequencies in the current window
	2. Populate the frequency map with the first k elements:
		. Loop from i = 0 to i < k
		. For each nums[i], increment its count in the frequency map
	3. Compute the x-sum for the first window:
		. Call computeXSum(freq, x) and assign the result to result[0]
	4. Slide the window from i = k to i < n:
		. Decrement the count of nums[i - k] (element exiting the window)
			. If its frequency becomes zero, remove it from the map
		. Increment the count of nums[i] (element entering the window)
		. Call computeXSum(freq, x) and store the result in result[i - k + 1]
	5. Return the result[] array
	
	Helper Method: computeXSum(freqMap, x)
	1. Convert the freqMap into a list of integer arrays freqList[]
		. Each element is of the form [value, frequency]
	2. Sort freqList using the following criteria:
		. Primary: descending order of frequency
		. Secondary: descending order of value (to resolve ties)
	3. Select the top x elements from the sorted list:
		. Use a Set<Integer> to store the selected values
	4. Calculate the x-sum:
		. Iterate through the original freqMap
		. For each entry, if its key exists in the top x set:
			. Add key × frequency to the sum
	5. Return the calculated sum
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @param x: an integer
     * @return: an integer array answer of length n - k + 1
     */
	public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = computeXSum(freq, x);
        
        for (int i = k; i < n; i++) {
            // remove leftmost
            int left = nums[i - k];
            freq.put(left, freq.get(left) - 1);
            if (freq.get(left) == 0) freq.remove(left);
            
            // add new right
            int right = nums[i];
            freq.put(right, freq.getOrDefault(right, 0) + 1);
            
            result[i - k + 1] = computeXSum(freq, x);
        }
        
        return result;
    }

    private int computeXSum(Map<Integer, Integer> freq, int x) {
        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            freqList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // Sort by frequency DESC, then value DESC
        freqList.sort((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
            return Integer.compare(b[0], a[0]);
        });

        Set<Integer> topX = new HashSet<>();
        for (int i = 0; i < Math.min(x, freqList.size()); i++) {
            topX.add(freqList.get(i)[0]);
        }

        // Sum up only top x frequent values
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (topX.contains(entry.getKey())) {
                sum += entry.getKey() * entry.getValue();
            }
        }
        return sum;
    }

}
