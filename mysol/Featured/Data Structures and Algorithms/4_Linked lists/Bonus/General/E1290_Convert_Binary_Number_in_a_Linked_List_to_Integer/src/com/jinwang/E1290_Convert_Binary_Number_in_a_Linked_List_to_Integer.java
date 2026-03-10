package com.jinwang;

public class E1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {

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
    static int getDecimalValue(ListNode head) {

        int result = 0;

        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }

        return result;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [1,0,1]
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(0);
        ListNode a3 = new ListNode(1);

        a1.next = a2;
        a2.next = a3;

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

        int result1 = getDecimalValue(head1);

        System.out.println("Output: " + result1);
        System.out.println();


        // Example 2: head = [0]
        ListNode b1 = new ListNode(0);

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

        int result2 = getDecimalValue(head2);

        System.out.println("Output: " + result2);
	}

}
