package com.designCompressedStringIterator;
import java.util.*;

/*
Design and implement a data structure for a compressed string iterator. 
The given compressed string will be in the form of each letter followed 
by a positive integer representing the number of this letter existing 
in the original uncompressed string.

Implement the StringIterator class:

. next() Returns the next character if the original string still has 
  uncompressed characters, otherwise returns a white space.
. hasNext() Returns true if there is any letter needs to be uncompressed 
  in the original string, otherwise returns false.
*/

public class E604_Design_Compressed_String_Iterator {

	public static void main(String[] args) {
		E604_Design_Compressed_String_Iterator stringIterator = new E604_Design_Compressed_String_Iterator("L1e2t1C1o1d1e1");
        
        System.out.println(stringIterator.next()); // Output: L
        System.out.println(stringIterator.next()); // Output: e
        System.out.println(stringIterator.next()); // Output: e
        System.out.println(stringIterator.next()); // Output: t
        System.out.println(stringIterator.next()); // Output: C
        System.out.println(stringIterator.next()); // Output: o
        System.out.println(stringIterator.hasNext()); // Output: true
        System.out.println(stringIterator.next()); // Output: d
        System.out.println(stringIterator.hasNext()); // Output: true
        System.out.println(stringIterator.next()); // Output: e
        System.out.println(stringIterator.hasNext()); // Output: false
	}
	
	/*
    solution:
    Initialize the iterator with the compressed string.
	Set the initial index, count, and current character.
	Extract the first character and its count.
    */
	
	/*
     * @param compressedString: a string
     * @return: next() or hasNext()
     */
	private String compressedString;
    private int index;
    private int count;
    private char currentChar;

    public E604_Design_Compressed_String_Iterator(String compressedString) {
        this.compressedString = compressedString;
        this.index = 0;
        this.count = 0;
        this.currentChar = ' ';
        // Initialize the first character and its count
        if (compressedString.length() > 0) {
            currentChar = compressedString.charAt(index++);
            count = 0;
            while (index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
                count = count * 10 + (compressedString.charAt(index++) - '0');
            }
        }
    }
    
    public char next() {
        if (count == 0) {
            if (index >= compressedString.length()) {
                return ' ';
            }
            currentChar = compressedString.charAt(index++);
            count = 0;
            while (index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
                count = count * 10 + (compressedString.charAt(index++) - '0');
            }
        }
        count--;
        return currentChar;
    }
    
    public boolean hasNext() {
        return count > 0 || index < compressedString.length();
    }

}
