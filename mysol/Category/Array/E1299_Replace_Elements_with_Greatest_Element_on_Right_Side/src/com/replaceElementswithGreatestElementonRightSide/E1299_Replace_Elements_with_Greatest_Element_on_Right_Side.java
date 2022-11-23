package com.replaceElementswithGreatestElementonRightSide;

public class E1299_Replace_Elements_with_Greatest_Element_on_Right_Side {

	public static void main(String[] args) {
		int[] input = {17,18,5,4,6,1};
		int[] output = replaceElements(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Iterate from the back to the start,
	We initilize mx = -1, where mx represent the max on the right.
	Each round, we set A[i] = mx, where mx is its mas on the right.
	Also we update mx = max(mx, A[i]), where A[i] is its original value.
    */
	
	/*
     * @param arr: a list of integers
     * @return: an array
     */
	public static int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1, mx = -1; i >= 0; --i) {
            mx = Math.max(arr[i], arr[i] = mx);
        }
        return arr;
    }

}
