package com.searchSuggestionsSystem;
import java.util.*;

/*
You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products 
after each character of searchWord is typed. Suggested products should 
have common prefix with searchWord. If there are more than three products 
with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of 
searchWord is typed.
*/

public class M1268_Search_Suggestions_System {

	public static void main(String[] args) {
		String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";
        List<List<String>> result1 = suggestedProducts(products1, searchWord1);
        System.out.println("Test Case 1: " + result1);
	}
	
	
	private static class TrieNode {
        Map<Character, TrieNode> children;
        List<String> suggestions;

        public TrieNode() {
            children = new HashMap<>();
            suggestions = new ArrayList<>();
        }
    }

    private static TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode node = root;
            for (char ch : product.toCharArray()) {
                node = node.children.computeIfAbsent(ch, k -> new TrieNode());
                if (node.suggestions.size() < 3) {
                    node.suggestions.add(product);
                }
            }
        }
        return root;
    }
    
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = buildTrie(products);
        List<List<String>> result = new ArrayList<>();

        TrieNode node = root;
        for (char ch : searchWord.toCharArray()) {
            node = node.children.getOrDefault(ch, new TrieNode());
            result.add(node.suggestions);
        }

        return result;
    }

}
