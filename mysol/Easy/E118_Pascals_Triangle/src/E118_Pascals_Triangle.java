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
    
    */
	
	/**
     * @param numRows: an integer
     * @return: an ArrayList
     */
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		
		if(numRows == 0) {
			return rst;
		}
		
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(0 ,1);
		rst.add(first);
		
		for(int i = 1; i < numRows; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);
			for(int j = 0; j < i + 1; j++) {
				tmp.add(-1);
			}
			ArrayList<Integer> prev = rst.get(i - 1);
			tmp.set(0, prev.get(0));
			tmp.set(i, prev.get(i - 1));
			for(int j = 1; j < i; j++) {
				tmp.set(j, prev.get(j - 1) + prev.get(j));
			}
			rst.add(tmp);
		}
		
		return rst;
	}

}
