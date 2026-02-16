package com.jinwang;

public class Ch4_fast_slow_exp1 {

	static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static int getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }
	
	public static void main(String[] args) {
		// Build 1 -> 2 -> 3 -> 4 -> 5
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode head = one;

        System.out.println("Input:");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();

        int middle = getMiddle(head);

        System.out.println("Middle value:");
        System.out.println(middle);
	}

}
