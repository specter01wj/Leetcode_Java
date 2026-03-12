class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

class MyLinkedList {
  head: ListNode | null;
  size: number;

  constructor() {
    this.head = null;
    this.size = 0;
  }

  get(index: number): number {
    if (index < 0 || index >= this.size) {
      return -1;
    }

    let current: ListNode | null = this.head;
    for (let i = 0; i < index; i++) {
      current = current!.next;
    }

    return current!.val;
  }

  addAtHead(val: number): void {
    const newNode: ListNode = new ListNode(val, this.head);
    this.head = newNode;
    this.size++;
  }

  addAtTail(val: number): void {
    const newNode: ListNode = new ListNode(val);

    if (this.head === null) {
      this.head = newNode;
      this.size++;
      return;
    }

    let current: ListNode = this.head;
    while (current.next !== null) {
      current = current.next;
    }

    current.next = newNode;
    this.size++;
  }

  addAtIndex(index: number, val: number): void {
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

    let current: ListNode = this.head as ListNode;
    for (let i = 0; i < index - 1; i++) {
      current = current.next as ListNode;
    }

    const newNode: ListNode = new ListNode(val, current.next);
    current.next = newNode;
    this.size++;
  }

  deleteAtIndex(index: number): void {
    if (index < 0 || index >= this.size) {
      return;
    }

    if (index === 0) {
      this.head = this.head!.next;
      this.size--;
      return;
    }

    let current: ListNode = this.head as ListNode;
    for (let i = 0; i < index - 1; i++) {
      current = current.next as ListNode;
    }

    current.next = current.next!.next;
    this.size--;
  }
}

(document.getElementById("title") as HTMLElement).innerText =
"707. Design Linked List (TS)";

let output: string = "";

const myLinkedList: MyLinkedList = new MyLinkedList();

output += "<b>=== Example 1 ===</b><br>";

output += "addAtHead(1)<br>";
myLinkedList.addAtHead(1);

output += "addAtTail(3)<br>";
myLinkedList.addAtTail(3);

output += "addAtIndex(1, 2)<br>";
myLinkedList.addAtIndex(1, 2);

output += "get(1)<br>";
const result1: number = myLinkedList.get(1);
output += "Output: " + result1 + "<br>";

output += "deleteAtIndex(1)<br>";
myLinkedList.deleteAtIndex(1);

output += "get(1)<br>";
const result2: number = myLinkedList.get(1);
output += "Output: " + result2 + "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;