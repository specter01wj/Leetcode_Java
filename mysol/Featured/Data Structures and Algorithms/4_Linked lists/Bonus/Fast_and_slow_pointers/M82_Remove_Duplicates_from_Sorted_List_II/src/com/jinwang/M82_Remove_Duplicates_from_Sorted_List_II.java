package com.jinwang;

public class M82_Remove_Duplicates_from_Sorted_List_II {

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

    static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0, head);

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {

                int dupVal = curr.val;

                while (curr != null && curr.val == dupVal) {
                    curr = curr.next;
                }

                prev.next = curr;

            } else {

                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [1,2,3,3,4,4,5]
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(4);
        ListNode a7 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

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

        ListNode result1 = deleteDuplicates(head1);

        System.out.print("Output: ");
        ListNode q1 = result1;
        while (q1 != null) {
            System.out.print(q1.val);
            if (q1.next != null) System.out.print(" -> ");
            q1 = q1.next;
        }
        System.out.println();
        System.out.println();


        // Example 2: head = [1,1,1,2,3]
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(2);
        ListNode b5 = new ListNode(3);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

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

        ListNode result2 = deleteDuplicates(head2);

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
