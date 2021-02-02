package com.removeDuplicatesfromSortedList;
import java.util.*;

/*Given the head of a sorted linked list, delete all duplicates 
 such that each element appears only once. Return the linked list sorted as well.



Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]*/

public class E83_Remove_Duplicates_from_Sorted_List {

	public static void main(String[] args) {
		ListNode input = new ListNode(1);
		input.next = new ListNode(1);
		input.next.next = new ListNode(2);
		input.next.next.next = new ListNode(3);
		input.next.next.next.next = new ListNode(3);
		ListNode output = deleteDuplicates(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    跳过相同的元素，指向再后一个元素。
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
	public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
