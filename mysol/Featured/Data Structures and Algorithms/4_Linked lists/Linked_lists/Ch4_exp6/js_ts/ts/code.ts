/**
 * Dummy Pointer - Doubly Linked List (TS)
 */

class ListNode {
  val: number;
  next: ListNode | null;
  prev: ListNode | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}

(document.getElementById("title") as HTMLElement).innerText =
  "Dummy Pointer - Doubly Linked List (TS)";

// Create nodes
const one: ListNode = new ListNode(1);
const two: ListNode = new ListNode(2);
const three: ListNode = new ListNode(3);

// Link forward
one.next = two;
two.next = three;

// Link backward
two.prev = one;
three.prev = two;

const head: ListNode = one;

let output: string = "";

// Print list
output += "Created Doubly Linked List:<br>";
let current: ListNode | null = head;
while (current !== null) {
  output += current.val;
  if (current.next !== null) {
    output += " <-> ";
  }
  current = current.next;
}
output += "<br><br>";

// Dummy traversal sum
let ans: number = 0;
let dummy: ListNode | null = head;
while (dummy !== null) {
  ans += dummy.val;
  dummy = dummy.next;
}

output += "Sum using dummy pointer: " + ans + "<br><br>";
output += "Head still at: " + head.val;

(document.getElementById("output") as HTMLElement).innerHTML = output;