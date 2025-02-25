package com.maximumHeightofaTriangle;
import java.util.*;

/*
You are given two integers red and blue representing the count 
of red and blue colored balls. You have to arrange these balls 
to form a triangle such that the 1st row will have 1 ball, 
the 2nd row will have 2 balls, the 3rd row will have 3 balls, 
and so on.

All the balls in a particular row should be the same color, 
and adjacent rows should have different colors.

Return the maximum height of the triangle that can be achieved.
*/

public class E3200_Maximum_Height_of_a_Triangle {

	public static void main(String[] args) {
		E3200_Maximum_Height_of_a_Triangle solution = new E3200_Maximum_Height_of_a_Triangle();
		int red = 2, blue = 1;
		int output = solution.maxHeightOfTriangle(red, blue);
        System.out.println("red: " + (red) + "; blue: " + (blue) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Alternating Color Choice:
		. The odd rows (1st, 3rd, 5th, …) use the primary color (whichever is passed first).
		. The even rows (2nd, 4th, 6th, …) use the secondary color.
	2. Two Calls:
		. Math.max(buildTriangle(red, blue), buildTriangle(blue, red)) 
		ensures that we try both starting color arrangements and return 
		the best result.
	3. Loop Process:
		. Start with row 1, check if enough balls are available.
		. Deduct balls and increase the height.
		. Repeat for the next row until a row cannot be formed.
    */
	
	/*
     * @param red: an integer
     * @param blue: an integer
     * @return: the maximum height of the triangle that can be achieved
     */
	public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(buildTriangle(red, blue), buildTriangle(blue, red));
    }

    private int buildTriangle(int primary, int secondary) {
        int height = 0;
        int i = 1; // The number of balls required for the current row

        while (true) {
            if (i % 2 == 1) { // Odd rows use the primary color
                if (primary >= i) {
                    primary -= i;
                } else {
                    break;
                }
            } else { // Even rows use the secondary color
                if (secondary >= i) {
                    secondary -= i;
                } else {
                    break;
                }
            }
            height++; // Successfully added another row
            i++; // Move to the next row
        }

        return height;
    }

}
