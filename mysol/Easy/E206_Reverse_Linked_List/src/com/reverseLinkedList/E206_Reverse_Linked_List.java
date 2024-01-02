package com.reverseLinkedList;
import java.util.*;

/*
Given the head of a singly linked list, reverse the list, and 
return the reversed list.
*/

public class E206_Reverse_Linked_List {

	public static void main(String[] args) {
		ListNode input = new ListNode(1);
		input.next = new ListNode(2);
		input.next.next = new ListNode(3);
		input.next.next.next = new ListNode(4);
		input.next.next.next.next = new ListNode(5);
		System.out.println("input: " + listToString(input));
		ListNode output = reverseList(input);
        System.out.println("output: " + listToString(output));
	}
	
	/*
    solution:
    Linked List
    */
	
	/*
     * @param head: The first node of linked list.
     * @return: the reversed list
     */
	public static ListNode reverseList(ListNode head) {
        ListNode prev = null;      // Initialize previous node to null
        ListNode current = head;   // Start with the head of the list
        ListNode next = null;      // Initialize next node

        while (current != null) {
            next = current.next;   // Store next node
            current.next = prev;   // Reverse the current node's pointer
            prev = current;        // Move pointers one position forward
            current = next;
        }

        return prev;  // Prev will be the new head of the reversed list
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
