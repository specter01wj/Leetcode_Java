package com.jinwang;

public class M19_Remove_Nth_Node_From_End_of_List {

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

    static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
	
	public static void main(String[] args) {
		// Example 1: [1,2,3,4,5], n = 2
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
        int n1 = 2;

        System.out.println("Example 1 Input:");
        ListNode p1 = head1;
        while (p1 != null) {
            System.out.print(p1.val);
            if (p1.next != null) System.out.print(" -> ");
            p1 = p1.next;
        }
        System.out.println();
        System.out.println("n = " + n1);

        ListNode result1 = removeNthFromEnd(head1, n1);

        System.out.println("Example 1 Output:");
        ListNode q1 = result1;
        while (q1 != null) {
            System.out.print(q1.val);
            if (q1.next != null) System.out.print(" -> ");
            q1 = q1.next;
        }
        System.out.println();
        System.out.println();


        // Example 2: [1], n = 1
        ListNode head2 = new ListNode(1);
        int n2 = 1;

        System.out.println("Example 2 Input:");
        ListNode p2 = head2;
        while (p2 != null) {
            System.out.print(p2.val);
            if (p2.next != null) System.out.print(" -> ");
            p2 = p2.next;
        }
        System.out.println();
        System.out.println("n = " + n2);

        ListNode result2 = removeNthFromEnd(head2, n2);

        System.out.println("Example 2 Output:");
        ListNode q2 = result2;
        while (q2 != null) {
            System.out.print(q2.val);
            if (q2.next != null) System.out.print(" -> ");
            q2 = q2.next;
        }
        System.out.println();
        System.out.println();


        // Example 3: [1,2], n = 1
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        ListNode head3 = a;
        int n3 = 1;

        System.out.println("Example 3 Input:");
        ListNode p3 = head3;
        while (p3 != null) {
            System.out.print(p3.val);
            if (p3.next != null) System.out.print(" -> ");
            p3 = p3.next;
        }
        System.out.println();
        System.out.println("n = " + n3);

        ListNode result3 = removeNthFromEnd(head3, n3);

        System.out.println("Example 3 Output:");
        ListNode q3 = result3;
        while (q3 != null) {
            System.out.print(q3.val);
            if (q3.next != null) System.out.print(" -> ");
            q3 = q3.next;
        }
        System.out.println();
	}

}
