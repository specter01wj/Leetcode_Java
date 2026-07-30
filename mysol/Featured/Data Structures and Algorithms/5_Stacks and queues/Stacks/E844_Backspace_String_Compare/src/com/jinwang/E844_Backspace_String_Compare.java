package com.jinwang;

import java.util.Stack;

public class E844_Backspace_String_Compare {

	public static void main(String[] args) {
		E844_Backspace_String_Compare solution = new E844_Backspace_String_Compare();

        String s1 = "ab#c";
        String t1 = "ad#c";

        String s2 = "ab##";
        String t2 = "c#d#";

        String s3 = "a#c";
        String t3 = "b";

        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"" + "\nOutput: " + solution.backspaceCompare(s1, t1));
        System.out.println();

        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"" + "\nOutput: " + solution.backspaceCompare(s2, t2));
        System.out.println();

        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\"" + "\nOutput: " + solution.backspaceCompare(s3, t3));
	}
	
	public boolean backspaceCompare(String s, String t) {
		Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                stackS.push(c);
            } else if (!stackS.empty()) {
                stackS.pop();
            }
        }

        for (char c : t.toCharArray()) {
            if (c != '#') {
                stackT.push(c);
            } else if (!stackT.empty()) {
                stackT.pop();
            }
        }

        return stackS.equals(stackT);
	}

}
