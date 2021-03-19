package com.similarRGBColor;
import java.util.*;

/*In the following, every capital letter represents some hexadecimal 
digit from 0 to f.

The red-green-blue color "#AABBCC" can be written as "#ABC" in 
shorthand.  For example, "#15c" is shorthand for the color "#1155cc".

Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" 
is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.

Given the color "#ABCDEF", return a 7 character color that is most 
similar to #ABCDEF, and has a shorthand (that is, 
it can be represented as some "#XYZ"

Example 1:
Input: color = "#09f166"
Output: "#11ee66"
Explanation:  
The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - 
(0x66 - 0x66)^2 = -64 -9 -0 = -73.
This is the highest among any shorthand color.*/

public class E800_Similar_RGB_Color {

	public static void main(String[] args) {
		String input = "#09f166";
        String output = similarRGB(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    形如AA的十六进制数必定是17的倍数，我们只要判断离原数最接近的17的倍数是多少即可。
    */
	
	/**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
	public static String similarRGB(String color) {
		StringBuilder sb = new StringBuilder(color.length());
		sb.append("#");
		for(int i = 1; i < color.length(); i += 2) {
			sb.append(getHexDigits(color.charAt(i), color.charAt(i + 1)));
		}
		
		return sb.toString();
	}
	
	public static String getHexDigits(char c1, char c2) {
		int d1 = Character.isDigit(c1) ? c1 - '0' : 10 + c1 - 'a';
		int d2 = Character.isDigit(c2) ? c2 - '0' : 10 + c2 - 'a';
		
		int sum = d1 * 16 + d2;
		int index = sum / 17;
		int remainder = sum % 17;
		if(remainder > 17 / 2) index++;
		
		char c = (0 <= index && index <= 9) ? (char)('0' + index) : (char)('a' + index - 10);
		
		return String.valueOf(c) + String.valueOf(c);
	}

}
