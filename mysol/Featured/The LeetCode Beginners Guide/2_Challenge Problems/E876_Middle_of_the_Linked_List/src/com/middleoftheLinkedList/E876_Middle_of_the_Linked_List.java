package com.middleoftheLinkedList;
import java.util.*;

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
*/

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(" -> ");
            curr = curr.next;
        }
        return sb.toString();
    }
}

public class E876_Middle_of_the_Linked_List {

	public static void main(String[] args) {
		E876_Middle_of_the_Linked_List solution = new E876_Middle_of_the_Linked_List();
		ListNode input = new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(5,
                                new ListNode(6))))));
		ListNode output = solution.middleNode(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
