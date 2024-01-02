package com.maximumTwinSumofaLinkedList;
import java.util.*;

/*
In a linked list of size n, where n is even, the ith node (0-indexed) 
of the linked list is known as the twin of the (n-1-i)th node, 
if 0 <= i <= (n / 2) - 1.

 .For example, if n = 4, then node 0 is the twin of node 3, and node 1 
  is the twin of node 2. These are the only nodes with twins for n = 4.

The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum 
twin sum of the linked list.
*/

public class M2130_Maximum_Twin_Sum_of_a_Linked_List {

	public static void main(String[] args) {
		ListNode input = new ListNode(5);
		input.next = new ListNode(4);
		input.next.next = new ListNode(2);
		input.next.next.next = new ListNode(1);
		System.out.println("input: " + listToString(input));
		int output = pairSum(input);
        System.out.println("output: " + (output));
	}
	
	/*
    solution:
    Linked List
    */
	
	/*
     * @param head: The first node of linked list.
     * @return: the maximum twin sum of the linked list
     */
	public static int pairSum(ListNode head) {
        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null, current = slow, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Step 3 & 4: Calculate the twin sum and find the maximum
        int maxSum = 0;
        ListNode firstHalf = head, secondHalf = prev;
        while (secondHalf != null) {
            int twinSum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, twinSum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 5: Return the maximum twin sum
        return maxSum;
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
