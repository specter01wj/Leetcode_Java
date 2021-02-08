package com.intersectionofTwoLinkedLists;
import java.util.*;

/*Write a program to find the node at which the intersection of 
 two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], 
		skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 
(note that this must not be 0 if the two lists intersect). 
From the head of A, it reads as [4,1,8,4,5]. From the head of B, 
it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected 
node in A; There are 3 nodes before the intersected node in B.
 

Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], 
		skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 
(note that this must not be 0 if the two lists intersect). 
From the head of A, it reads as [1,9,1,2,4]. From the head of B, 
it reads as [3,2,4]. There are 3 nodes before the intersected node in A; 
There are 1 node before the intersected node in B.
 

Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, 
it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, 
while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.*/

public class E160_Intersection_of_Two_Linked_Lists {

	public static void main(String[] args) {
		ListNode input1 = new ListNode(4);
		input1.next = new ListNode(1);
		input1.next.next = new ListNode(8);
		input1.next.next.next = new ListNode(4);
		input1.next.next.next.next = new ListNode(5);
		ListNode input2 = new ListNode(5);
		input2.next = new ListNode(6);
		input2.next.next = new ListNode(1);
		input2.next.next.next = new ListNode(8);
		input2.next.next.next.next = new ListNode(4);
		input2.next.next.next.next.next = new ListNode(5);
		ListNode output = getIntersectionNode(input1, input2);
        System.out.println("input1: " + (input1) + "input2: " + (input2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    分别找出两个长度
	让长的先走到剩余长度和短的一样地方
	然后让两个同时走到第一个node相同的地方, 返回结果即可
	
	每个LinkedList最多遍历两次, 时间复杂度 O(n), n为两LinkedList长度和
	空间复杂度O(1)
    */
	
	/**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        // get the tail of list A.
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode result = listCycleII(headA);
        node.next = null;
        return result;
    }
    
    private static ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
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
