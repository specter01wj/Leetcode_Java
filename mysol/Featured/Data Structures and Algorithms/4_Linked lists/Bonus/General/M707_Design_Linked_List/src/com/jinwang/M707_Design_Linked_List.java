package com.jinwang;

public class M707_Design_Linked_List {

	static class MyLinkedList {

        static class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }
        }

        ListNode head;
        int size;

        public MyLinkedList() {
            head = null;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            ListNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.val;
        }

        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                size++;
                return;
            }

            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            if (index == size) {
                addAtTail(val);
                return;
            }

            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            ListNode newNode = new ListNode(val);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            if (index == 0) {
                head = head.next;
                size--;
                return;
            }

            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
            size--;
        }
    }
	
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();

        System.out.println("=== Example 1 ===");

        System.out.println("addAtHead(1)");
        myLinkedList.addAtHead(1);

        System.out.println("addAtTail(3)");
        myLinkedList.addAtTail(3);

        System.out.println("addAtIndex(1, 2)");
        myLinkedList.addAtIndex(1, 2);

        System.out.println("get(1)");
        int result1 = myLinkedList.get(1);
        System.out.println("Output: " + result1);

        System.out.println("deleteAtIndex(1)");
        myLinkedList.deleteAtIndex(1);

        System.out.println("get(1)");
        int result2 = myLinkedList.get(1);
        System.out.println("Output: " + result2);
	}

}
