import java.util.*;

/*Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
*/

public class E119_Pascals_Triangle_II {

	public static void main(String[] args) {
		int input = 5;
		ArrayList<Integer> output = new ArrayList<Integer>();
        output = getRow(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    
    */
	
	/**
     * @param numRows: an integer
     * @return: an Array
     */
	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
        rowIndex += 1;
        
        if (rowIndex == 0) {
            return rst;
        }

        rst.add(1);
        for (int i = 1; i < rowIndex; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                tmp.add(-1);
            }
            tmp.set(0, rst.get(0));
            tmp.set(i, rst.get(i - 1));
            for (int j = 1; j < i; j++) {
                tmp.set(j, rst.get(j - 1) + rst.get(j));
            }
            rst = tmp;
        }
        
        return rst;
    }

}
