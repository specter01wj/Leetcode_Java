package com.jinwang;

public class M1721_Swapping_Nodes_in_a_Linked_List {

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

    // Implementation (clean, submission-style)
    static ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode fast = first;
        ListNode second = head;

        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
	
	public static void main(String[] args) {
		// Example 1
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode head1 = a1;
        int k1 = 2;

        System.out.println("=== Example 1 ===");
        System.out.print("Input : ");
        ListNode p1 = head1;
        while (p1 != null) {
            System.out.print(p1.val);
            if (p1.next != null) System.out.print(" -> ");
            p1 = p1.next;
        }
        System.out.println();
        System.out.println("k = " + k1);

        ListNode result1 = swapNodes(head1, k1);

        System.out.print("Output: ");
        ListNode q1 = result1;
        while (q1 != null) {
            System.out.print(q1.val);
            if (q1.next != null) System.out.print(" -> ");
            q1 = q1.next;
        }
        System.out.println();
        System.out.println();


        // Example 2
        ListNode b1 = new ListNode(7);
        ListNode b2 = new ListNode(9);
        ListNode b3 = new ListNode(6);
        ListNode b4 = new ListNode(6);
        ListNode b5 = new ListNode(7);
        ListNode b6 = new ListNode(8);
        ListNode b7 = new ListNode(3);
        ListNode b8 = new ListNode(0);
        ListNode b9 = new ListNode(9);
        ListNode b10 = new ListNode(5);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = b7;
        b7.next = b8;
        b8.next = b9;
        b9.next = b10;

        ListNode head2 = b1;
        int k2 = 5;

        System.out.println("=== Example 2 ===");
        System.out.print("Input : ");
        ListNode p2 = head2;
        while (p2 != null) {
            System.out.print(p2.val);
            if (p2.next != null) System.out.print(" -> ");
            p2 = p2.next;
        }
        System.out.println();
        System.out.println("k = " + k2);

        ListNode result2 = swapNodes(head2, k2);

        System.out.print("Output: ");
        ListNode q2 = result2;
        while (q2 != null) {
            System.out.print(q2.val);
            if (q2.next != null) System.out.print(" -> ");
            q2 = q2.next;
        }
        System.out.println();
	}

}
