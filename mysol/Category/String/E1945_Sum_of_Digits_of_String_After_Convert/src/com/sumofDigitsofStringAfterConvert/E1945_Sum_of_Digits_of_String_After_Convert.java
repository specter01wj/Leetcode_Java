package com.sumofDigitsofStringAfterConvert;
import java.util.*;





public class E1945_Sum_of_Digits_of_String_After_Convert {

	public static void main(String[] args) {
		String input = "leetcode";
		int k = 2;
        int output = getLucky(input, k);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < s.length();i++)
        sb.append((s.charAt(i) - 'a') + 1);
        String result = sb.toString();
 
        if (result.length() == 1) {
            return Character.getNumericValue(result.charAt(0));
        }
        
        int sum = 0;
        while (k-- > 0 && result.length() > 1) {   
            sum = 0;
            for (int i=0;i<result.length();i++) {
                sum += Character.getNumericValue(result.charAt(i));
            }
            result=String.valueOf(sum);
        }
        
        return sum;
    }

}
