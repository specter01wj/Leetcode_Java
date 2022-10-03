package com.defanginganIPAddress;
import java.util.*;

/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".


Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
*/

public class E1108_Defanging_an_IP_Address {

	public static void main(String[] args) {
		String input = "1.1.1.1";
        String output = defangIPaddr(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Create an empty list. Iterate through the characters in the address, 
    numbers get appended to the list while periods signal that "[.]" chars 
    must be appended.
    */
	
	/**
     * @param s: a string
     * @return: A defanged IP address replaces every period "." with "[.]"
     */
	public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            sb.append(c == '.' ? "[.]" : c);
        }
        return sb.toString();
    }

}
