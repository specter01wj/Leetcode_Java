package com.numberofStudentsUnabletoEatLunch;
import java.util.*;

/*
The school cafeteria offers circular and square sandwiches at lunch break, 
referred to by numbers 0 and 1 respectively. All students stand in a queue. 
Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. 
The sandwiches are placed in a stack. At each step:

	.If the student at the front of the queue prefers the sandwich on the top 
	 of the stack, they will take it and leave the queue.
	.Otherwise, they will leave it and go to the queue's end.

This continues until none of the queue students want to take the top sandwich 
and are thus unable to eat.

You are given two integer arrays students and sandwiches where sandwiches[i] 
is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) 
and students[j] is the preference of the j​​​​​​th student in the initial queue 
(j = 0 is the front of the queue). Return the number of students that are unable to eat.


Example 1:

Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0 
Explanation:
- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
Hence all students are able to eat.

Example 2:

Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3
*/

public class E1700_Number_of_Students_Unable_to_Eat_Lunch {

	public static void main(String[] args) {
		int[] input = {1,1,0,0}, sandwiches = {0,1,0,1};
		int output = countStudents(input, sandwiches);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Count students' preference of food to count
	Now we iterate the food one by one,
	and see if any one in the left students queue will take it.
	We stop at sandwiches[k] if no one wants it,
	then n - k students are unable to eat.
    */
	
	/*
     * @param students: a list of integers
     * @param sandwiches: a list of integers
     * @return: the number of students that are unable to eat
     */
	public static int countStudents(int[] students, int[] sandwiches) {
        int count[] = {0, 0}, n = students.length, k;
        for (int i : students) {
            count[i]++;
        }
        for (k = 0; k < n && count[sandwiches[k]] > 0; ++k) {
            count[sandwiches[k]]--;
        }
        return n - k;
    }

}
