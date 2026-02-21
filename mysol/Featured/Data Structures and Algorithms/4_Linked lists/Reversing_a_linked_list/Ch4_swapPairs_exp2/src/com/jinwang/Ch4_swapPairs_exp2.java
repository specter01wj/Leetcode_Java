package com.jinwang;

public class Ch4_swapPairs_exp2 {

	static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode swapPairs(ListNode head) {
        // Check edge case: linked list has 0 or 1 nodes, just return
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = head.next;     // Step 5
        ListNode prev = null;           // Initialize for step 3

        while (head != null && head.next != null) {

            if (prev != null) {
                prev.next = head.next;  // Step 4
            }

            prev = head;                // Step 3

            // Step 2
            ListNode nextNode = head.next.next;

            head.next.next = head;      // Step 1

            head.next = nextNode;       // Step 6
            head = nextNode;            // Move to next pair (Step 3)
        }

        return dummy;
    }
	
	public static void main(String[] args) {
		// Case 1: 1 -> 2 -> 3 -> 4
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        ListNode head1 = one;

        System.out.println("Case 1 Input:");
        ListNode current1 = head1;
        while (current1 != null) {
            System.out.print(current1.val);
            if (current1.next != null) {
                System.out.print(" -> ");
            }
            current1 = current1.next;
        }
        System.out.println();

        ListNode result1 = swapPairs(head1);

        System.out.println("Case 1 Output:");
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

        // Case 2: 1 -> 2 -> 3
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        ListNode head2 = a;

        System.out.println("Case 2 Input:");
        ListNode current2 = head2;
        while (current2 != null) {
            System.out.print(current2.val);
            if (current2.next != null) {
                System.out.print(" -> ");
            }
            current2 = current2.next;
        }
        System.out.println();

        ListNode result2 = swapPairs(head2);

        System.out.println("Case 2 Output:");
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
