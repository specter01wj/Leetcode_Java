package com.jinwang;

public class Ch4_reverse_exp1 {

	static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
	
	public static void main(String[] args) {
		// Build 1 -> 2 -> 3 -> 4
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        ListNode head = one;

        System.out.println("Input:");
        ListNode current1 = head;
        while (current1 != null) {
            System.out.print(current1.val);
            if (current1.next != null) {
                System.out.print(" -> ");
            }
            current1 = current1.next;
        }
        System.out.println();

        ListNode reversed = reverseList(head);

        System.out.println("Output:");
        ListNode current2 = reversed;
        while (current2 != null) {
            System.out.print(current2.val);
            if (current2.next != null) {
                System.out.print(" -> ");
            }
            current2 = current2.next;
        }
        System.out.println();
	}

}
