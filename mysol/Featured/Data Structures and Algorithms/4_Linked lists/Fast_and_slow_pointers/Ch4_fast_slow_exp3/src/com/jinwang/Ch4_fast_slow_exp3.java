package com.jinwang;

import java.util.HashSet;
import java.util.Set;

public class Ch4_fast_slow_exp3 {

	static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static boolean detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();

        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }

        return false;
    }
	
	public static void main(String[] args) {
		// Case 1: 1 -> 2 -> 3 -> 4 -> 5 (no cycle)
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode head1 = one;

        System.out.println("Case 1 (No Cycle):");
        ListNode current = head1;
        int count = 0;
        while (current != null && count < 10) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
            count++;
        }
        System.out.println();

        boolean result1 = detectCycle(head1);
        System.out.println("Has Cycle:");
        System.out.println(result1);

        System.out.println();

        // Case 2: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle)
        ListNode six = new ListNode(1);
        ListNode seven = new ListNode(2);
        ListNode eight = new ListNode(3);
        ListNode nine = new ListNode(4);
        ListNode ten = new ListNode(5);

        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;
        ten.next = eight; // create cycle

        ListNode head2 = six;

        System.out.println("Case 2 (With Cycle):");
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle)");

        boolean result2 = detectCycle(head2);
        System.out.println("Has Cycle:");
        System.out.println(result2);
	}

}
