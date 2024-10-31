package com.countHousesinaCircularStreet;
import java.util.*;




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
