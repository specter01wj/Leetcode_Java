package com.countHousesinaCircularStreet;
import java.util.*;

/*
You are given an object street of class Street that represents a 
circular street and a positive integer k which represents a maximum 
bound for the number of houses in that street (in other words, 
the number of houses is less than or equal to k). Houses' doors 
could be open or closed initially.

Initially, you are standing in front of a door to a house on this street. 
Your task is to count the number of houses in the street.

The class Street contains the following functions which may help you:

	. void openDoor(): Open the door of the house you are in front of.
	. void closeDoor(): Close the door of the house you are in front of.
	. boolean isDoorOpen(): Returns true if the door of the current house is open and false otherwise.
	. void moveRight(): Move to the right house.
	. void moveLeft(): Move to the left house.

Return ans which represents the number of houses on this street.
*/

class Street {
    private boolean[] doors;
    private int currentPosition;

    public Street(int[] doorStates) {
        doors = new boolean[doorStates.length];
        for (int i = 0; i < doorStates.length; i++) {
            doors[i] = doorStates[i] == 1;
        }
        currentPosition = 0; // Start at the first house
    }

    public void openDoor() {
        doors[currentPosition] = true;
    }

    public void closeDoor() {
        doors[currentPosition] = false;
    }

    public boolean isDoorOpen() {
        return doors[currentPosition];
    }

    public void moveRight() {
        currentPosition = (currentPosition + 1) % doors.length;
    }

    public void moveLeft() {
        currentPosition = (currentPosition - 1 + doors.length) % doors.length;
    }
}

public class E2728_Count_Houses_in_a_Circular_Street {

	public static void main(String[] args) {
		E2728_Count_Houses_in_a_Circular_Street solution = new E2728_Count_Houses_in_a_Circular_Street();
		int[] input = {1,0,1,1,0};
		int k = 5;
		Street street = new Street(input);
		int output = solution.houseCount(street, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. First Loop (Setup Phase):
		. We iterate k times, moving around the circular street to ensure 
			that if there are fewer than k houses, we have fully circled around.
		. For each house, if the door is open, we close it. This ensures a 
			consistent starting state for counting.
	2. Marking the Starting Point:
		. After the initial loop, we open the current door and move to the 
			next house. This marks the starting point with an open door, 
			making it easy to detect when we have completed a full loop.
	3. Counting Houses:
		. We initialize ans to 0 and then move right, counting each house 
			until we encounter the marked starting house with an open door.
		. When we reach the open door, it signifies a complete loop, and we 
			return ans + 1 (to include the starting house).
    */
	
	/*
     * @param arr: a list of integers
     * @param k: an integer
     * @return: ans which represents the number of houses on this street
     */
	public int houseCount(Street street, int k) {
        // Prepare a consistent state by closing doors and moving k steps
        for (int i = 0; i < k; i++) {
            if (street.isDoorOpen()) {
                street.closeDoor();
            }
            street.moveRight();
        }

        // Mark the starting point by opening the current door and moving to the next house
        street.openDoor();
        street.moveRight();

        int houseCount = 0;

        // Count houses until we encounter the open door again
        while (!street.isDoorOpen()) {
            houseCount += 1;
            street.moveRight();
        }

        // Include the starting house in the count
        return houseCount + 1;
    }

}
