package com.convertDoublyLinkedListtoArrayI;
import java.util.*;

/*
You are given the head of a doubly linked list, which contains 
nodes that have a next pointer and a previous pointer.

Return an integer array which contains the elements of the linked list in order.
*/

class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
    }
}

public class E3263_Convert_Doubly_Linked_List_to_Array_I {

	public static void main(String[] args) {
		E3263_Convert_Doubly_Linked_List_to_Array_I solution = new E3263_Convert_Doubly_Linked_List_to_Array_I();
		int[] input = {1, 2, 3, 4, 3, 2, 1};
		Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        
        int[] output = solution.toArray(head);
        
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] toArray(Node head) {
        if (head == null) {
            return new int[0];
        }

        // First, determine the length of the linked list
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Create an array of the determined size
        int[] result = new int[length];

        // Populate the array with values from the linked list
        current = head;
        for (int i = 0; i < length; i++) {
            result[i] = current.val;
            current = current.next;
        }

        return result;
    }

}
