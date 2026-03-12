class ListNode {
    val;
    next;
    constructor(val, next = null) {
        this.val = val;
        this.next = next;
    }
}
class MyLinkedList {
    head;
    size;
    constructor() {
        this.head = null;
        this.size = 0;
    }
    get(index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }
        let current = this.head;
        for (let i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }
    addAtHead(val) {
        const newNode = new ListNode(val, this.head);
        this.head = newNode;
        this.size++;
    }
    addAtTail(val) {
        const newNode = new ListNode(val);
        if (this.head === null) {
            this.head = newNode;
            this.size++;
            return;
        }
        let current = this.head;
        while (current.next !== null) {
            current = current.next;
        }
        current.next = newNode;
        this.size++;
    }
    addAtIndex(index, val) {
        if (index < 0 || index > this.size) {
            return;
        }
        if (index === 0) {
            this.addAtHead(val);
            return;
        }
        if (index === this.size) {
            this.addAtTail(val);
            return;
        }
        let current = this.head;
        for (let i = 0; i < index - 1; i++) {
            current = current.next;
        }
        const newNode = new ListNode(val, current.next);
        current.next = newNode;
        this.size++;
    }
    deleteAtIndex(index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        if (index === 0) {
            this.head = this.head.next;
            this.size--;
            return;
        }
        let current = this.head;
        for (let i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        this.size--;
    }
}
document.getElementById("title").innerText =
    "707. Design Linked List (TS)";
let output = "";
const myLinkedList = new MyLinkedList();
output += "<b>=== Example 1 ===</b><br>";
output += "addAtHead(1)<br>";
myLinkedList.addAtHead(1);
output += "addAtTail(3)<br>";
myLinkedList.addAtTail(3);
output += "addAtIndex(1, 2)<br>";
myLinkedList.addAtIndex(1, 2);
output += "get(1)<br>";
const result1 = myLinkedList.get(1);
output += "Output: " + result1 + "<br>";
output += "deleteAtIndex(1)<br>";
myLinkedList.deleteAtIndex(1);
output += "get(1)<br>";
const result2 = myLinkedList.get(1);
output += "Output: " + result2 + "<br>";
document.getElementById("output").innerHTML = output;
