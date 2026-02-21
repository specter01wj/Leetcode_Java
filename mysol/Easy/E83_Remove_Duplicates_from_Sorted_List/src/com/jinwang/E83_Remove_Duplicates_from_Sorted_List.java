package com.jinwang;

public class E83_Remove_Duplicates_from_Sorted_List {

	static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [1,1,2]
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);

        one.next = two;
        two.next = three;

        ListNode head1 = one;

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

        ListNode result1 = deleteDuplicates(head1);

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

        // Example 2: head = [1,1,2,3,3]
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode head2 = a;

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

        ListNode result2 = deleteDuplicates(head2);

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
