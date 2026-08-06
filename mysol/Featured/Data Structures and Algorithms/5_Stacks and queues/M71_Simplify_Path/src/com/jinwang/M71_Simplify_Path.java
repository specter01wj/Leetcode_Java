package com.jinwang;

import java.util.Stack;

public class M71_Simplify_Path {

	public static void main(String[] args) {
		M71_Simplify_Path solution = new M71_Simplify_Path();

        String input1 = "/home/";
        String input2 = "/home//foo/";
        String input3 = "/home/user/Documents/../Pictures";
        String input4 = "/../";
        String input5 = "/.../a/../b/c/../d/./";

        System.out.println("Input: " + input1 +
                "\nOutput: " + solution.simplifyPath(input1));
        System.out.println();

        System.out.println("Input: " + input2 +
                "\nOutput: " + solution.simplifyPath(input2));
        System.out.println();

        System.out.println("Input: " + input3 +
                "\nOutput: " + solution.simplifyPath(input3));
        System.out.println();

        System.out.println("Input: " + input4 +
                "\nOutput: " + solution.simplifyPath(input4));
        System.out.println();

        System.out.println("Input: " + input5 +
                "\nOutput: " + solution.simplifyPath(input5));
	}
	
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        if (stack.empty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        return ans.toString();
    }

}
