package com.jinwang;

public class Ch4_exp1 {
	
	/**
     * Example 1: Creating and Traversing a Singly Linked List.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

	public static void main(String[] args) {
		// Create nodes
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        // Link nodes: 1 -> 2 -> 3 -> null
        one.next = two;
        two.next = three;

        // Head reference
        ListNode head = one;

        // Traversal (recommended approach)
        System.out.println("Traversing linked list:");

        ListNode current = head;

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
	}

}
