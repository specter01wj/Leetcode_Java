package com.goalParserInterpretation;
import java.util.*;

/*
You own a Goal Parser that can interpret a string command. 
The command consists of an alphabet of "G", "()" and/or "(al)" in some order. 
The Goal Parser will interpret "G" as the string "G", "()" as the string "o", 
and "(al)" as the string "al". 
The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.


Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".

Example 2:

Input: command = "G()()()()(al)"
Output: "Gooooal"

Example 3:

Input: command = "(al)G(al)()()G"
Output: "alGalooG"
*/

public class E1678_Goal_Parser_Interpretation {

	public static void main(String[] args) {
		String input = "G()()()()(al)";
        String output = interpret(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    StringBuilder
    */
	
	/**
     * @param command: a string
     * @return: the Goal Parser's interpretation of command
     */
	public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); ++i) {
            char c = command.charAt(i);
            if (c == 'G') {
                sb.append(c);
            } else if (c == '(' && command.charAt(i + 1) == ')') {
                sb.append("o");
                ++i;
            } else {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }

}
