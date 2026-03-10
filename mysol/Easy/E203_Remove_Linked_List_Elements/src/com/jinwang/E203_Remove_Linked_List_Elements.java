package com.jinwang;

public class E203_Remove_Linked_List_Elements {

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
    static ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [1,2,6,3,4,5,6], val = 6
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(5);
        ListNode a7 = new ListNode(6);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        ListNode head1 = a1;
        int val1 = 6;

        System.out.println("=== Example 1 ===");
        System.out.print("Input : ");
        ListNode p1 = head1;
        while (p1 != null) {
            System.out.print(p1.val);
            if (p1.next != null) System.out.print(" -> ");
            p1 = p1.next;
        }
        System.out.println();
        System.out.println("val = " + val1);

        ListNode result1 = removeElements(head1, val1);

        System.out.print("Output: ");
        ListNode q1 = result1;
        while (q1 != null) {
            System.out.print(q1.val);
            if (q1.next != null) System.out.print(" -> ");
            q1 = q1.next;
        }
        System.out.println();
        System.out.println();


        // Example 2: head = [], val = 1
        ListNode head2 = null;
        int val2 = 1;

        System.out.println("=== Example 2 ===");
        System.out.print("Input : ");
        ListNode p2 = head2;
        while (p2 != null) {
            System.out.print(p2.val);
            if (p2.next != null) System.out.print(" -> ");
            p2 = p2.next;
        }
        System.out.println();
        System.out.println("val = " + val2);

        ListNode result2 = removeElements(head2, val2);

        System.out.print("Output: ");
        ListNode q2 = result2;
        while (q2 != null) {
            System.out.print(q2.val);
            if (q2.next != null) System.out.print(" -> ");
            q2 = q2.next;
        }
        System.out.println();
        System.out.println();


        // Example 3: head = [7,7,7,7], val = 7
        ListNode c1 = new ListNode(7);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(7);
        ListNode c4 = new ListNode(7);

        c1.next = c2;
        c2.next = c3;
        c3.next = c4;

        ListNode head3 = c1;
        int val3 = 7;

        System.out.println("=== Example 3 ===");
        System.out.print("Input : ");
        ListNode p3 = head3;
        while (p3 != null) {
            System.out.print(p3.val);
            if (p3.next != null) System.out.print(" -> ");
            p3 = p3.next;
        }
        System.out.println();
        System.out.println("val = " + val3);

        ListNode result3 = removeElements(head3, val3);

        System.out.print("Output: ");
        ListNode q3 = result3;
        while (q3 != null) {
            System.out.print(q3.val);
            if (q3.next != null) System.out.print(" -> ");
            q3 = q3.next;
        }
        System.out.println();
	}

}
