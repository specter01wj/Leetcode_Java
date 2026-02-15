package com.jinwang;

public class Ch4_exp5 {

	/**
     * Example 5: Doubly Linked List with Sentinel Nodes
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode head = new ListNode(-1); // sentinel head
    static ListNode tail = new ListNode(-1); // sentinel tail

    // Initialize
    static {
        head.next = tail;
        tail.prev = head;
    }

    public static void addToEnd(ListNode nodeToAdd) {
        nodeToAdd.next = tail;
        nodeToAdd.prev = tail.prev;
        tail.prev.next = nodeToAdd;
        tail.prev = nodeToAdd;
    }

    public static void removeFromEnd() {
        if (head.next == tail) {
            return; // empty
        }

        ListNode nodeToRemove = tail.prev;
        nodeToRemove.prev.next = tail;
        tail.prev = nodeToRemove.prev;
    }

    public static void addToStart(ListNode nodeToAdd) {
        nodeToAdd.prev = head;
        nodeToAdd.next = head.next;
        head.next.prev = nodeToAdd;
        head.next = nodeToAdd;
    }

    public static void removeFromStart() {
        if (head.next == tail) {
            return;
        }

        ListNode nodeToRemove = head.next;
        nodeToRemove.next.prev = head;
        head.next = nodeToRemove.next;
    }

    public static void printList() {
        ListNode current = head.next;
        while (current != tail) {
            System.out.print(current.val);
            if (current.next != tail) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		System.out.println("Initial (empty):");
        printList();

        // Test remove on empty
        removeFromStart();
        removeFromEnd();

        System.out.println("After removeFromStart() & removeFromEnd() on empty:");
        printList();

        // Add operations
        addToStart(new ListNode(10));
        System.out.println("After addToStart(10):");
        printList();

        addToEnd(new ListNode(20));
        System.out.println("After addToEnd(20):");
        printList();

        addToStart(new ListNode(5));
        System.out.println("After addToStart(5):");
        printList();

        addToEnd(new ListNode(30));
        System.out.println("After addToEnd(30):");
        printList();

        // Remove operations
        removeFromStart();
        System.out.println("After removeFromStart():");
        printList();

        removeFromEnd();
        System.out.println("After removeFromEnd():");
        printList();

        removeFromStart();
        System.out.println("After removeFromStart():");
        printList();

        removeFromEnd();
        System.out.println("After removeFromEnd() (back to empty):");
        printList();
	}

}
