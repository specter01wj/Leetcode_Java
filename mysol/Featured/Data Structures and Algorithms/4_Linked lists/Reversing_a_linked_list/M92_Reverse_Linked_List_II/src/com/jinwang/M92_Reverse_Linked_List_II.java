package com.jinwang;

public class M92_Reverse_Linked_List_II {

	static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [1,2,3,4,5], left = 2, right = 4
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
        int left1 = 2;
        int right1 = 4;

        System.out.println("Example 1 Input:");
        ListNode current1 = head1;
        while (current1 != null) {
            System.out.print(current1.val);
            if (current1.next != null) {
                System.out.print(" -> ");
            }
            current1 = current1.next;
        }
        System.out.println();
        System.out.println("left = " + left1 + ", right = " + right1);

        ListNode result1 = reverseBetween(head1, left1, right1);

        System.out.println("Example 1 Output:");
        ListNode out1 = result1;
        while (out1 != null) {
            System.out.print(out1.val);
            if (out1.next != null) {
                System.out.print(" -> ");
            }
            out1 = out1.next;
        }
        System.out.println();
        System.out.println();

        // Example 2: head = [5], left = 1, right = 1
        ListNode head2 = new ListNode(5);
        int left2 = 1;
        int right2 = 1;

        System.out.println("Example 2 Input:");
        ListNode current2 = head2;
        while (current2 != null) {
            System.out.print(current2.val);
            if (current2.next != null) {
                System.out.print(" -> ");
            }
            current2 = current2.next;
        }
        System.out.println();
        System.out.println("left = " + left2 + ", right = " + right2);

        ListNode result2 = reverseBetween(head2, left2, right2);

        System.out.println("Example 2 Output:");
        ListNode out2 = result2;
        while (out2 != null) {
            System.out.print(out2.val);
            if (out2.next != null) {
                System.out.print(" -> ");
            }
            out2 = out2.next;
        }
        System.out.println();
	}

}
