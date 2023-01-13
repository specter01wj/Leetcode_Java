package com.countItemsMatchingaRule;
import java.util.*;

/*
You are given an array items, where each items[i] = [typei, colori, namei] 
describes the type, color, and name of the ith item. 
You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

	.ruleKey == "type" and ruleValue == typei.
	.ruleKey == "color" and ruleValue == colori.
	.ruleKey == "name" and ruleValue == namei.
	
Return the number of items that match the given rule.


Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], 
ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, 
which is ["computer","silver","lenovo"].

Example 2:

Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], 
ruleKey = "type", ruleValue = "phone"
Output: 2
Explanation: There are only two items matching the given rule, 
which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. 
Note that the item ["computer","silver","phone"] does not match.
*/

public class E1773_Count_Items_Matching_a_Rule {

	public static void main(String[] args) {
		List<List<String>> input = Arrays.asList(Arrays.asList("phone","blue","pixel"), Arrays.asList("computer","silver","phone"), Arrays.asList("phone","gold","iphone"));
		String ruleKey = "type", ruleValue = "phone";
		int output = countMatches(input, ruleKey, ruleValue);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        
        for (int i = 0;i < items.size();i++) {
            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)) res++;
            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)) res++;
            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)) res++;
        }
        
        return res;
    }

}
