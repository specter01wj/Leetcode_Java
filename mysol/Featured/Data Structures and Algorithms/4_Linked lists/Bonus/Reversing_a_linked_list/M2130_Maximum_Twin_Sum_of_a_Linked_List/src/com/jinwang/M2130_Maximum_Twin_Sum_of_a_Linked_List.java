package com.jinwang;

public class M2130_Maximum_Twin_Sum_of_a_Linked_List {

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

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    static int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow);

        int max = 0;

        ListNode firstHalf = head;
        ListNode currentSecond = secondHalf;

        while (currentSecond != null) {
            int sum = firstHalf.val + currentSecond.val;
            if (sum > max) {
                max = sum;
            }
            firstHalf = firstHalf.next;
            currentSecond = currentSecond.next;
        }

        return max;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [5,4,2,1]
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;

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

        int result1 = pairSum(head1);

        System.out.println("Example 1 Output:");
        System.out.println(result1);
        System.out.println();

        // Example 2: head = [4,2,2,3]
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);

        a.next = b;
        b.next = c;
        c.next = d;

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

        int result2 = pairSum(head2);

        System.out.println("Example 2 Output:");
        System.out.println(result2);
        System.out.println();

        // Example 3: head = [1,100000]
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(100000);

        x.next = y;

        ListNode head3 = x;

        System.out.println("Example 3 Input:");
        ListNode current3 = head3;
        while (current3 != null) {
            System.out.print(current3.val);
            if (current3.next != null) {
                System.out.print(" -> ");
            }
            current3 = current3.next;
        }
        System.out.println();

        int result3 = pairSum(head3);

        System.out.println("Example 3 Output:");
        System.out.println(result3);
	}

}
