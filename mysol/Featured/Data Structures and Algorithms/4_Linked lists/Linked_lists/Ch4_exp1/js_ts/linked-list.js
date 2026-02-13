/**
 * Chapter 4 – Linked Lists
 * Example 1: Create and Traverse
 */

class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

function createLinkedList() {
  const one = new ListNode(1);
  const two = new ListNode(2);
  const three = new ListNode(3);

  one.next = two;
  two.next = three;

  return one; // head
}

function traverseLinkedList(head) {
  const values = [];
  let current = head;

  while (current !== null) {
    values.push(current.val);
    current = current.next;
  }

  return values;
}

/* =========================
   Testing Section
========================= */

const head = createLinkedList();
const result = traverseLinkedList(head);

console.log(">>> Chapter 4 – Linked List: Create & Traverse");
console.log("Structure: 1 → 2 → 3 → null");
console.log("Traversal Output:", result.join(" → "));