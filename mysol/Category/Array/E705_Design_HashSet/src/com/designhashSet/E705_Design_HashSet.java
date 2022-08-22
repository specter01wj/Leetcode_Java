package com.designhashSet;
import java.util.*;

/*
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. 
If key does not exist in the HashSet, do nothing.


Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", 
"contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
*/

public class E705_Design_HashSet {

	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		boolean test1 = false;
		myHashSet.add(1);      // set = [1]
		myHashSet.add(2);      // set = [1, 2]
		test1 = myHashSet.contains(1); // return True
		test1 = myHashSet.contains(3); // return False, (not found)
		myHashSet.add(2);      // set = [1, 2]
		test1 = myHashSet.contains(2); // return True
		myHashSet.remove(2);   // set = [1]
		test1 = myHashSet.contains(2); // return False, (already removed)
	}
	
	static class MyHashSet {
	    int num[];
	    public MyHashSet() {
	        num = new int[10];
	    }

		public void add(int key) {
	        num[getIdx(key)]|=getMask(key);
	    }
	    
	    public void remove(int key) {
	        num[getIdx(key)] &= (~getMask(key));
	    }
	    
	    public boolean contains(int key) {
	        return (num[getIdx(key)]&getMask(key))!=0;
	    }
	    
	    private int getIdx(int key) {
	        return (key/32);
	    }
	    
	    private int getMask(int key) {
	        key%=32;
	        return (1<<key);
	    }
	}
	
	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */

}
