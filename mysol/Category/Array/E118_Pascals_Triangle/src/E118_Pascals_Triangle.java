import java.util.*;

/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class E118_Pascals_Triangle {

	public static void main(String[] args) {
		int input = 5;
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output = generate(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Using Extra Array
	Algorithm
	We use an extra array in which we place every element of the array 
	at its correct position i.e. the number at index ii in the original 
	array is placed at the index (i+k)%(length of array)(i+k). 
	Then, we copy the new array to the original one.
    */
	
	/**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		
		return rst;
	}

}
