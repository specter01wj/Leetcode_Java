package com.jinwang;

public class Ch4_fast_slow_exp4 {

	static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode findNode(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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

        int k = 2;

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

        System.out.println("k:");
        System.out.println(k);

        ListNode result = findNode(head, k);

        System.out.println("kth node from end:");
        System.out.println(result.val);
	}

}
