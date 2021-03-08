package com.studentAttendanceRecordI;
import java.util.*;

/*You are given a string s representing an attendance record 
for a student. The record only contains the following three characters:
'A': Absent.
'L': Late.
'P': Present.
A student could be rewarded if his attendance record does not contain 
more than one 'A' (absent) or more than two consecutive 'L' (late).

Return true if the student could be rewarded according to his attendance 
record, and false otherwise.

 

Example 1:

Input: s = "PPALLP"
Output: true

Example 2:

Input: s = "PPALLL"
Output: false*/

public class E551_Student_Attendance_Record_I {

	public static void main(String[] args) {
		String input = "PPALLP";
        boolean output = checkRecord(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	public static boolean checkRecord(String s) {
		int count_A = 0;
		s += "##";
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'A') {
				count_A++;
			}
			if(count_A > 1 || (s.charAt(i) == 'L' && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L')) {
				return false;
			}
		}
		
		return true;
	}

}
