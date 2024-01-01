package com.deletetheMiddleNodeofaLinkedList;
import java.util.*;

/*
You are given the head of a linked list. Delete the middle node, 
and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node 
from the start using 0-based indexing, where ⌊x⌋ denotes the 
largest integer less than or equal to x.

 .For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, 
  respectively.
*/

public class M2095_Delete_the_Middle_Node_of_a_Linked_List {

	public static void main(String[] args) {
		ListNode input = new ListNode(1);
		input.next = new ListNode(3);
		input.next.next = new ListNode(4);
		input.next.next.next = new ListNode(7);
		input.next.next.next.next = new ListNode(1);
		input.next.next.next.next.next = new ListNode(2);
		input.next.next.next.next.next.next = new ListNode(6);
		System.out.println("input: " + listToString(input));
		ListNode output = deleteMiddle(input);
        System.out.println("output: " + listToString(output));
	}
	
	/*
    solution:
    Linked List
    */
	
	/*
     * @param head: The first node of linked list.
     * @return: the head of the modified linked list
     */
	public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        prev.next = slow.next;

        return head;
    }
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static String listToString(ListNode node) {
	    StringBuilder sb = new StringBuilder();
	    while (node != null) {
	        sb.append(node.val);
	        if (node.next != null) {
	            sb.append(" -> ");
	        }
	        node = node.next;
	    }
	    return sb.toString();
	}

}
