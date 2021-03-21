package com.uniqueMorseCodeWords;
import java.util.*;

/*International Morse Code defines a standard encoding where 
each letter is mapped to a series of dots and dashes, 
as follows: "a" maps to ".-", "b" maps to "-...", "c" maps 
to "-.-.", and so on.

For convenience, the full table for the 26 letters of the 
English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",
 ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
 "...","-","..-","...-",".--","-..-","-.--","--.."]

Now, given a list of words, each word can be written as a 
concatenation of the Morse code of each letter. 
For example, "cab" can be written as "-.-..--...", 
(which is the concatenation "-.-." + ".-" + "-..."). 
We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2

Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".*/

public class E804_Unique_Morse_Code_Words {

	public static void main(String[] args) {
		String[] input = {"gin", "zen", "gig", "msg"};
        int output = uniqueMorseRepresentations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	public static int uniqueMorseRepresentations(String[] words) {
		String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
		HashSet<String> s = new HashSet<>();
		
		for(String word : words) {
			String code = "";
			for(char c : word.toCharArray()) {
				code += d[c - 'a'];
			}
			s.add(code);
		}
		
		return s.size();
	}

}
