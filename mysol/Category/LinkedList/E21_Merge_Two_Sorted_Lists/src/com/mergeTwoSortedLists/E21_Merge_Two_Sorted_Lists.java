package com.mergeTwoSortedLists;
import java.util.*;

/*Merge two sorted linked lists and return it as a sorted list. 
 The list should be made by splicing together the nodes of the first two lists.

		 

Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]*/

public class E21_Merge_Two_Sorted_Lists {

	public static void main(String[] args) {
		ListNode input1 = new ListNode(1);
		input1.next = new ListNode(2);
		input1.next = new ListNode(4);
		ListNode input2 = new ListNode(1);
		input2.next = new ListNode(3);
		input2.next = new ListNode(4);
		ListNode output = mergeTwoLists(input1, input2);
        System.out.println("input1: " + (input1) + 
        		"input2: " + (input2) + 
        		"\noutput: " + (output));
	}
	
	/*
    solution:
    与合并数组一个方法，两个指针往后走。
    */
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }
        
        return dummy.next;
    }
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
