package com.greatestCommonDivisorofStrings;

public class E1071_Greatest_Common_Divisor_of_Strings {

	public static void main(String[] args) {
		String input1 = "ABABAB";
		String input2 = "ABAB";
        String output = gcdOfStrings(input1, input2);
        System.out.println("input1: " + (input1) + " Input2: " + (input2) + "\noutput: " + (output));   
	}
	
	
	public static String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)) {
            return "";
        }
    
        int gcdVal = gcd(str1.length() , str2.length());
        return str2.substring(0, gcdVal);
    }
    
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

}
