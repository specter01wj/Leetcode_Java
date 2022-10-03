package com.defanginganIPAddress;
import java.util.*;





public class E1108_Defanging_an_IP_Address {

	public static void main(String[] args) {
		String input = "1.1.1.1";
        String output = defangIPaddr(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            sb.append(c == '.' ? "[.]" : c);
        }
        return sb.toString();
    }

}
