package com.jinwang;

public class Ch4_exp7 {
	
	public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
    }

	public static void main(String[] args) {
		// Create nodes
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        // Link forward
        one.next = two;
        two.next = three;

        // Link backward
        two.prev = one;
        three.prev = two;

        ListNode head = one;

        System.out.println("Doubly Linked List:");

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }

        System.out.println();
	}

}
