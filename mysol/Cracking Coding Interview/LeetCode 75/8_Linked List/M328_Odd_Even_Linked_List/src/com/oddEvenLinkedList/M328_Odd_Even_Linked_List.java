package com.oddEvenLinkedList;
import java.util.*;

/*
Given the head of a singly linked list, group all the nodes with odd 
indices together followed by the nodes with even indices, and return 
the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should 
remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time 
complexity.
*/

public class M328_Odd_Even_Linked_List {

	public static void main(String[] args) {
		ListNode input = new ListNode(1);
		input.next = new ListNode(2);
		input.next.next = new ListNode(3);
		input.next.next.next = new ListNode(4);
		input.next.next.next.next = new ListNode(5);
		System.out.println("input: " + listToString(input));
		ListNode output = oddEvenList(input);
        System.out.println("output: " + listToString(output));
	}
	
	/*
    solution:
    Linked List
    */
	
	/*
     * @param head: The first node of linked list.
     * @return: the reordered list
     */
	public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
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
