package com.implementTrie;
import java.util.*;

/*
A trie (pronounced as "try") or prefix tree is a tree data structure 
used to efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as 
autocomplete and spellchecker.

Implement the Trie class:

 .Trie() Initializes the trie object.
 .void insert(String word) Inserts the string word into the trie.
 .boolean search(String word) Returns true if the string word is in the trie 
  (i.e., was inserted before), and false otherwise.
 .boolean startsWith(String prefix) Returns true if there is a previously 
  inserted string word that has the prefix prefix, and false otherwise.
*/

public class M208_Implement_Trie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple"));   // should return true
        System.out.println("Search 'app': " + trie.search("app"));       // should return false
        System.out.println("Starts with 'app': " + trie.startsWith("app")); // should return true
        trie.insert("app");
        System.out.println("Search 'app' after insert: " + trie.search("app")); // should return true
	}
	
	
	static class Trie {
	    private class TrieNode {
	        private TrieNode[] children;
	        private boolean isEndOfWord;

	        public TrieNode() {
	            children = new TrieNode[26]; // Assuming only lowercase English letters.
	            isEndOfWord = false;
	        }

	        public boolean containsKey(char ch) {
	            return children[ch - 'a'] != null;
	        }

	        public TrieNode get(char ch) {
	            return children[ch - 'a'];
	        }

	        public void put(char ch, TrieNode node) {
	            children[ch - 'a'] = node;
	        }

	        public void setEnd() {
	            isEndOfWord = true;
	        }

	        public boolean isEnd() {
	            return isEndOfWord;
	        }
	    }

	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    public void insert(String word) {
	        TrieNode node = root;
	        for (int i = 0; i < word.length(); i++) {
	            char currentChar = word.charAt(i);
	            if (!node.containsKey(currentChar)) {
	                node.put(currentChar, new TrieNode());
	            }
	            node = node.get(currentChar);
	        }
	        node.setEnd();
	    }
	    
	    public boolean search(String word) {
	        TrieNode node = searchPrefix(word);
	        return node != null && node.isEnd();
	    }
	    
	    public boolean startsWith(String prefix) {
	        TrieNode node = searchPrefix(prefix);
	        return node != null;
	    }

	    private TrieNode searchPrefix(String word) {
	        TrieNode node = root;
	        for (int i = 0; i < word.length(); i++) {
	            char curLetter = word.charAt(i);
	            if (node.containsKey(curLetter)) {
	                node = node.get(curLetter);
	            } else {
	                return null;
	            }
	        }
	        return node;
	    }
	}

}
