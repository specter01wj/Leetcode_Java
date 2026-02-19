package com.jinwang;

public class E876_Middle_of_the_Linked_List {
	
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	static ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	

	public static void main(String[] args) {
		// Example 1: head = [1,2,3,4,5]
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

        ListNode mid1 = middleNode(head1);

        System.out.println("Example 1 Output:");
        ListNode out1 = mid1;
        while (out1 != null) {
            System.out.print(out1.val);
            if (out1.next != null) {
                System.out.print(" -> ");
            }
            out1 = out1.next;
        }
        System.out.println();
        System.out.println();

        // Example 2: head = [1,2,3,4,5,6]
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

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

        ListNode mid2 = middleNode(head2);

        System.out.println("Example 2 Output:");
        ListNode out2 = mid2;
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
