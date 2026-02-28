package com.jinwang;

public class M2095_Delete_the_Middle_Node_of_a_Linked_List {

	static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    static ListNode deleteMiddle(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        int step = 0;

        while (fast != null && fast.next != null) {
            step++;
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            System.out.println("Step " + step + ": prev=" + prev.val + ", slow=" + slow.val + ", fast=" + (fast == null ? "null" : fast.val));
        }

        System.out.println("Delete node (middle): " + slow.val);
        prev.next = slow.next;

        return head;
    }
	
	public static void main(String[] args) {
		// Example 1: [1,3,4,7,1,2,6]
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(1);
        ListNode a6 = new ListNode(2);
        ListNode a7 = new ListNode(6);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        ListNode head1 = a1;

        System.out.println("=== Example 1 ===");
        System.out.print("Before: ");
        ListNode p1 = head1;
        while (p1 != null) {
            System.out.print(p1.val);
            if (p1.next != null) System.out.print(" -> ");
            p1 = p1.next;
        }
        System.out.println();

        head1 = deleteMiddle(head1);

        System.out.print("After : ");
        ListNode q1 = head1;
        while (q1 != null) {
            System.out.print(q1.val);
            if (q1.next != null) System.out.print(" -> ");
            q1 = q1.next;
        }
        System.out.println();
        System.out.println();

        // Example 2: [1,2,3,4]
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;

        ListNode head2 = b1;

        System.out.println("=== Example 2 ===");
        System.out.print("Before: ");
        ListNode p2 = head2;
        while (p2 != null) {
            System.out.print(p2.val);
            if (p2.next != null) System.out.print(" -> ");
            p2 = p2.next;
        }
        System.out.println();

        head2 = deleteMiddle(head2);

        System.out.print("After : ");
        ListNode q2 = head2;
        while (q2 != null) {
            System.out.print(q2.val);
            if (q2.next != null) System.out.print(" -> ");
            q2 = q2.next;
        }
        System.out.println();
        System.out.println();

        // Example 3: [2,1]
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(1);

        c1.next = c2;

        ListNode head3 = c1;

        System.out.println("=== Example 3 ===");
        System.out.print("Before: ");
        ListNode p3 = head3;
        while (p3 != null) {
            System.out.print(p3.val);
            if (p3.next != null) System.out.print(" -> ");
            p3 = p3.next;
        }
        System.out.println();

        head3 = deleteMiddle(head3);

        System.out.print("After : ");
        ListNode q3 = head3;
        while (q3 != null) {
            System.out.print(q3.val);
            if (q3.next != null) System.out.print(" -> ");
            q3 = q3.next;
        }
        System.out.println();
	}

}
