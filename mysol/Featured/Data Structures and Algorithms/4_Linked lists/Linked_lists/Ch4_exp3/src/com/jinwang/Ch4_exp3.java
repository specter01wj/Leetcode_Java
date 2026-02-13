package com.jinwang;

public class Ch4_exp3 {

	/**
     * Example 3: Delete Node After Given Node
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Delete node after prevNode
    public static void deleteNode(ListNode prevNode) {
        if (prevNode == null || prevNode.next == null) {
            return; // safety check
        }

        prevNode.next = prevNode.next.next;
    }

    // Traverse and print
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
		// Create 1 -> 2 -> 3 -> 4
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        ListNode head = one;

        System.out.println("Before Delete:");
        printList(head);

        // Delete node 3 (prevNode is 2)
        deleteNode(two);

        System.out.println("After Delete (remove 3):");
        printList(head);
	}

}
