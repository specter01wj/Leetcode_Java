package com.jinwang;

public class M2074_Reverse_Nodes_in_Even_Length_Groups {

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
    static ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode current = head;
        ListNode prevGroupEnd = null;

        int groupSize = 1;

        while (current != null) {

            ListNode groupStart = current;

            ListNode temp = current;
            int count = 0;

            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {

                ListNode prev = temp;
                ListNode node = groupStart;

                for (int i = 0; i < count; i++) {
                    ListNode nextNode = node.next;
                    node.next = prev;
                    prev = node;
                    node = nextNode;
                }

                if (prevGroupEnd != null) {
                    prevGroupEnd.next = prev;
                } else {
                    head = prev;
                }

                prevGroupEnd = groupStart;
                current = temp;

            } else {

                for (int i = 0; i < count; i++) {
                    prevGroupEnd = current;
                    current = current.next;
                }

            }

            groupSize++;
        }

        return head;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [5,2,6,3,9,1,7,3,8,4]
        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(9);
        ListNode a6 = new ListNode(1);
        ListNode a7 = new ListNode(7);
        ListNode a8 = new ListNode(3);
        ListNode a9 = new ListNode(8);
        ListNode a10 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a8;
        a8.next = a9;
        a9.next = a10;

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

        ListNode result1 = reverseEvenLengthGroups(head1);

        System.out.print("Output: ");
        ListNode r1 = result1;
        while (r1 != null) {
            System.out.print(r1.val);
            if (r1.next != null) System.out.print(" -> ");
            r1 = r1.next;
        }
        System.out.println();
        System.out.println();


        // Example 2: head = [1,1,0,6]
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(0);
        ListNode b4 = new ListNode(6);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;

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

        ListNode result2 = reverseEvenLengthGroups(head2);

        System.out.print("Output: ");
        ListNode r2 = result2;
        while (r2 != null) {
            System.out.print(r2.val);
            if (r2.next != null) System.out.print(" -> ");
            r2 = r2.next;
        }
        System.out.println();
        System.out.println();


        // Example 3: head = [1,1,0,6,5]
        ListNode c1 = new ListNode(1);
        ListNode c2 = new ListNode(1);
        ListNode c3 = new ListNode(0);
        ListNode c4 = new ListNode(6);
        ListNode c5 = new ListNode(5);

        c1.next = c2;
        c2.next = c3;
        c3.next = c4;
        c4.next = c5;

        ListNode head3 = c1;

        System.out.println("=== Example 3 ===");
        System.out.print("Input : ");
        ListNode p3 = head3;
        while (p3 != null) {
            System.out.print(p3.val);
            if (p3.next != null) System.out.print(" -> ");
            p3 = p3.next;
        }
        System.out.println();

        ListNode result3 = reverseEvenLengthGroups(head3);

        System.out.print("Output: ");
        ListNode r3 = result3;
        while (r3 != null) {
            System.out.print(r3.val);
            if (r3.next != null) System.out.print(" -> ");
            r3 = r3.next;
        }
        System.out.println();
	}

}
