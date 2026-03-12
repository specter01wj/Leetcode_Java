package com.jinwang;

public class M328_Odd_Even_Linked_List {

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
    static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [1,2,3,4,5]
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

        System.out.println("=== Example 1 ===");
        System.out.print("Input : ");
        ListNode p1 = head1;
        while (p1 != null) {
            System.out.print(p1.val);
            if (p1.next != null) System.out.print(" -> ");
            p1 = p1.next;
        }
        System.out.println();

        ListNode result1 = oddEvenList(head1);

        System.out.print("Output: ");
        ListNode q1 = result1;
        while (q1 != null) {
            System.out.print(q1.val);
            if (q1.next != null) System.out.print(" -> ");
            q1 = q1.next;
        }
        System.out.println();
        System.out.println();


        // Example 2: head = [2,1,3,5,6,4,7]
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(5);
        ListNode b5 = new ListNode(6);
        ListNode b6 = new ListNode(4);
        ListNode b7 = new ListNode(7);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = b7;

        ListNode head2 = b1;

        System.out.println("=== Example 2 ===");
        System.out.print("Input : ");
        ListNode p2 = head2;
        while (p2 != null) {
            System.out.print(p2.val);
            if (p2.next != null) System.out.print(" -> ");
            p2 = p2.next;
        }
        System.out.println();

        ListNode result2 = oddEvenList(head2);

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
