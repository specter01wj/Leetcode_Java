package com.jinwang;

public class M24_Swap_Nodes_in_Pairs {

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

    static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = head.next;
        ListNode prev = null;

        while (head != null && head.next != null) {

            if (prev != null) {
                prev.next = head.next;
            }

            prev = head;

            ListNode nextNode = head.next.next;
            head.next.next = head;

            head.next = nextNode;
            head = nextNode;
        }

        return dummy;
    }
	
	public static void main(String[] args) {
		// Example 1: head = [1,2,3,4]
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

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

        ListNode result1 = swapPairs(head1);

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

        // Example 2: head = []
        ListNode head2 = null;

        System.out.println("Example 2 Input:");
        System.out.println("[]");

        ListNode result2 = swapPairs(head2);

        System.out.println("Example 2 Output:");
        if (result2 == null) {
            System.out.println("[]");
        } else {
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
        System.out.println();

        // Example 3: head = [1]
        ListNode head3 = new ListNode(1);

        System.out.println("Example 3 Input:");
        System.out.println("1");

        ListNode result3 = swapPairs(head3);

        System.out.println("Example 3 Output:");
        ListNode out3 = result3;
        while (out3 != null) {
            System.out.print(out3.val);
            if (out3.next != null) {
                System.out.print(" -> ");
            }
            out3 = out3.next;
        }
        System.out.println();
        System.out.println();

        // Example 4: head = [1,2,3]
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        ListNode head4 = a;

        System.out.println("Example 4 Input:");
        ListNode current4 = head4;
        while (current4 != null) {
            System.out.print(current4.val);
            if (current4.next != null) {
                System.out.print(" -> ");
            }
            current4 = current4.next;
        }
        System.out.println();

        ListNode result4 = swapPairs(head4);

        System.out.println("Example 4 Output:");
        ListNode out4 = result4;
        while (out4 != null) {
            System.out.print(out4.val);
            if (out4.next != null) {
                System.out.print(" -> ");
            }
            out4 = out4.next;
        }
        System.out.println();
	}

}
