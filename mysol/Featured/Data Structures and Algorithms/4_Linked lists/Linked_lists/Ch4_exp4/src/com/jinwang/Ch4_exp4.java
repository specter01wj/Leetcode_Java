package com.jinwang;

public class Ch4_exp4 {

	/**
     * Example 4: Doubly Linked List Insert & Delete
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Insert nodeToAdd BEFORE node
    public static void addNode(ListNode node, ListNode nodeToAdd) {

        ListNode prevNode = node.prev;

        nodeToAdd.next = node;
        nodeToAdd.prev = prevNode;

        if (prevNode != null) {
            prevNode.next = nodeToAdd;
        }

        node.prev = nodeToAdd;
    }

    // Delete node
    public static void deleteNode(ListNode node) {

        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
    }

    // Print forward
    public static void printForward(ListNode head) {
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
	
	public static void main(String[] args) {
		// Create 1 <-> 2 <-> 3
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.prev = one;

        two.next = three;
        three.prev = two;

        ListNode head = one;

        System.out.println("Initial List:");
        printForward(head);

        // Insert 99 before 2
        addNode(two, new ListNode(99));

        System.out.println("After Insert (99 before 2):");
        printForward(head);

        // Delete 3
        deleteNode(three);

        System.out.println("After Delete (remove 3):");
        printForward(head);
	}

}
