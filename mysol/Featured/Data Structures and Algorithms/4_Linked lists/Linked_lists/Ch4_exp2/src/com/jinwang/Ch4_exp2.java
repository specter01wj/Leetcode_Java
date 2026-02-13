package com.jinwang;

public class Ch4_exp2 {

	/**
     * Example 2: Insert Node After Given Node
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Insert node after prevNode
    public static void addNode(ListNode prevNode, ListNode nodeToAdd) {
        nodeToAdd.next = prevNode.next;
        prevNode.next = nodeToAdd;
    }

    // Traverse and print linked list
    public static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }
	
	public static void main(String[] args) {
		// Create 1 -> 2 -> 3
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;

        ListNode head = one;

        System.out.println("Before Insert:");
        printList(head);

        // Insert 99 after 2
        addNode(two, new ListNode(99));

        System.out.println("After Insert (99 after 2):");
        printList(head);
	}

}
