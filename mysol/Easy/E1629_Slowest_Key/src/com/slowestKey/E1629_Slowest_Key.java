package com.slowestKey;
import java.util.*;

/*
A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.

You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed 
in the testing sequence, and a sorted list releaseTimes, where releaseTimes[i] was the time 
the ith key was released. Both arrays are 0-indexed. The 0th key was pressed at the time 0, 
and every subsequent key was pressed at the exact time the previous key was released.

The tester wants to know the key of the keypress that had the longest duration. The ith 
keypress had a duration of releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress 
had a duration of releaseTimes[0].

Note that the same key could have been pressed multiple times during the test, and these 
multiple presses of the same key may not have had the same duration.

Return the key of the keypress that had the longest duration. If there are multiple such 
keypresses, return the lexicographically largest key of the keypresses.


Example 1:

Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
Output: "c"
Explanation: The keypresses were as follows:
Keypress for 'c' had a duration of 9 (pressed at time 0 and released at time 9).
Keypress for 'b' had a duration of 29 - 9 = 20 (pressed at time 9 right after 
the release of the previous character and released at time 29).
Keypress for 'c' had a duration of 49 - 29 = 20 (pressed at time 29 right after 
the release of the previous character and released at time 49).
Keypress for 'd' had a duration of 50 - 49 = 1 (pressed at time 49 right after 
the release of the previous character and released at time 50).
The longest of these was the keypress for 'b' and the second keypress for 'c', 
both with duration 20.
'c' is lexicographically larger than 'b', so the answer is 'c'.

Example 2:

Input: releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
Output: "a"
Explanation: The keypresses were as follows:
Keypress for 's' had a duration of 12.
Keypress for 'p' had a duration of 23 - 12 = 11.
Keypress for 'u' had a duration of 36 - 23 = 13.
Keypress for 'd' had a duration of 46 - 36 = 10.
Keypress for 'a' had a duration of 62 - 46 = 16.
The longest of these was the keypress for 'a' with duration 16.
*/

public class E1629_Slowest_Key {

	public static void main(String[] args) {
		int[] input = {9,29,49,50};
		String keysPressed = "cbcd";
		char output = slowestKey(input, keysPressed);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Traverse the input array and string, compute the press time for each character 
    and update the longest time.
    */
	
	/*
     * @param releaseTimes: a list of integers
     * @param keysPressed: a String
     * @return: the key of the keypress that had the longest duration
     */
	public static char slowestKey(int[] releaseTimes, String keysPressed) {
		int[] time = new int[26];
        for (int i = 0; i < releaseTimes.length; ++i) {
            char c = keysPressed.charAt(i);
            time[c - 'a'] = Math.max(time[c - 'a'], releaseTimes[i] - (i == 0 ? 0 : releaseTimes[i - 1]));
        }
        char ans = 'z';
        for (char c = 'y'; c >= 'a'; --c) {
            if (time[ans - 'a'] < time[c - 'a']) {
                ans = c;
            }
        }
        return ans; 
    }

}
