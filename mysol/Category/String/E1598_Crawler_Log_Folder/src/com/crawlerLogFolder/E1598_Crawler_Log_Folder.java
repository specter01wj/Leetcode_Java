package com.crawlerLogFolder;
import java.util.*;





public class E1598_Crawler_Log_Folder {

	public static void main(String[] args) {
		String[] input = {"d1/","d2/","../","d21/","./"};
        int output = minOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int minOperations(String[] logs) {
        int res = 0;
        for (String s : logs) {
            if (s.equals("../")) {
              res = Math.max(0, --res);  
            } else if (s.equals("./")) {
               continue; 
            } else {
              res++;  
            }
        }
        return res;
    }

}
