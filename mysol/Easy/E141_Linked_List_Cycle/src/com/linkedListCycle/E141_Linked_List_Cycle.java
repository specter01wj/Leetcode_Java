package com.linkedListCycle;
import java.util.*;

/*Given head, the head of a linked list, determine if the 
 linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list 
that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's 
next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects 
to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects 
to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.*/

public class E141_Linked_List_Cycle {

	public static void main(String[] args) {
		ListNode input = new ListNode(3);
		input.next = new ListNode(2);
		input.next.next = new ListNode(0);
		input.next.next.next = new ListNode(-4);
		Boolean output = hasCycle(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    快慢指针的经典题。 快指针每次走两步，慢指针一次走一步。 在慢指针进入环之后，
    快慢指针之间的距离每次缩小1，所以最终能相遇。
    */
	
	/*
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
	public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } 
        return true;
    }
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
