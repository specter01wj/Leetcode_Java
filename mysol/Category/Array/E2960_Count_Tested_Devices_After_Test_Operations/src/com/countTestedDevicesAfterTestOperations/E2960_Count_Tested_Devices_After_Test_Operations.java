package com.countTestedDevicesAfterTestOperations;
import java.util.*;

/*
You are given a 0-indexed integer array batteryPercentages having length n, 
denoting the battery percentages of n 0-indexed devices.

Your task is to test each device i in order from 0 to n - 1, by performing 
the following test operations:

	. If batteryPercentages[i] is greater than 0:
		. Increment the count of tested devices.
		. Decrease the battery percentage of all devices with indices j in 
			the range [i + 1, n - 1] by 1, ensuring their battery percentage 
			never goes below 0, i.e, batteryPercentages[j] = max(0, batteryPercentages[j] - 1).
		. Move to the next device.
	. Otherwise, move to the next device without performing any test.

Return an integer denoting the number of devices that will be tested after performing the test operations in order.
*/

public class E2960_Count_Tested_Devices_After_Test_Operations {

	public static void main(String[] args) {
		E2960_Count_Tested_Devices_After_Test_Operations solution = new E2960_Count_Tested_Devices_After_Test_Operations();
		int[] input = {1,1,2,1,3};
		int[] originalInput = Arrays.copyOf(input, input.length);
		int output = solution.countTestedDevices(input);
        System.out.println("input: " + Arrays.toString(originalInput) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Initialization:
		. n: The length of the batteryPercentages array.
		. testedDevices: Counter for the number of devices tested.
	2. Iterate through devices:
		. For each device i, check if its battery percentage is greater than 0:
			. If true:
				. Increment testedDevices.
				. For all devices with indices j in range [i + 1, n - 1], 
					decrease their battery percentage by 1 but ensure it 
					does not go below 0 using Math.max(0, batteryPercentages[j] - 1).
	3. Return the result:
		. Return the total count of tested devices.
    */
	
	/*
     * @param batteryPercentages: a list of integers
     * @return: an integer denoting the number of devices
     */
	public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int testedDevices = 0;

        for (int i = 0; i < n; i++) {
            // Check if the current device can be tested
            if (batteryPercentages[i] > 0) {
                testedDevices++;
                // Decrease the battery percentage for devices in range [i + 1, n - 1]
                for (int j = i + 1; j < n; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }

        return testedDevices;
    }

}