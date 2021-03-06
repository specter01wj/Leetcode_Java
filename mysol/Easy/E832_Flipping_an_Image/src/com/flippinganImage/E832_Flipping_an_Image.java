package com.flippinganImage;
import java.util.*;

/*Given an n x n binary matrix image, flip the image horizontally, 
then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is 
replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].
 

Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: 
First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:

Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: 
First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]*/

public class E832_Flipping_an_Image {

	public static void main(String[] args) {
		int[][] input = {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println("input: " + Arrays.deepToString(input));
        int[][] output = flipAndInvertImage(input);
        System.out.println("output: " + Arrays.deepToString(output));
	}
	
	/*
    solution:
    首先翻转每一行，然后遍历每个数字，或上1取反
    */
	
	/*
     * @param image: a 2D list of integers
     * @return: flip and invert the image
     */
	public static int[][] flipAndInvertImage(int[][] image) {
		int n = image.length;
		int m = image[0].length;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= (m - 1) / 2; j++) {
				if((image[i][j] ^ image[i][m - j - 1]) == 0) {
					if(image[i][j] == 0) {
						image[i][j] = 1;
						image[i][m - j - 1] = 1;
					} else {
						image[i][j] = 0;
						image[i][m - 1 - j] = 0;
					}
				}
			}
		}
		
		return image;
	}

}
