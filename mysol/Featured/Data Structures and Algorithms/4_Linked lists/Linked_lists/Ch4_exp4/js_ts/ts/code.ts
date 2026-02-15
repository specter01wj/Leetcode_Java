/**
 * Chapter 4 – Doubly Linked List
 * Insert & Delete
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

function addNode(node: ListNode, nodeToAdd: ListNode): void {
  const prevNode = node.prev;

  nodeToAdd.next = node;
  nodeToAdd.prev = prevNode;

  if (prevNode !== null) {
    prevNode.next = nodeToAdd;
  }

  node.prev = nodeToAdd;
}

function deleteNode(node: ListNode): void {
  const prevNode = node.prev;
  const nextNode = node.next;

  if (prevNode !== null) {
    prevNode.next = nextNode;
  }

  if (nextNode !== null) {
    nextNode.prev = prevNode;
  }
}

function traverse(head: ListNode | null): number[] {
  const values: number[] = [];
  let current: ListNode | null = head;

  while (current !== null) {
    values.push(current.val);
    current = current.next;
  }

  return values;
}

/* ========================
   Execution
======================== */

(document.getElementById("title") as HTMLElement).innerText =
  "Chapter 4 – Doubly Linked List (TS)";

// Create 1 <-> 2 <-> 3
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);

one.next = two;
two.prev = one;

two.next = three;
three.prev = two;

const head: ListNode = one;

// BEFORE
const before: number[] = traverse(head);

// Insert 99 before 2
addNode(two, new ListNode(99));
const afterInsert: number[] = traverse(head);

// Delete 3
deleteNode(three);
const afterDelete: number[] = traverse(head);

// CONSISTENT OUTPUT
(document.getElementById("output") as HTMLElement).innerHTML = `
  <p><b>Initial:</b> ${before.join(" <-> ")}</p>
  <p><b>After Insert (99 before 2):</b> ${afterInsert.join(" <-> ")}</p>
  <p><b>After Delete (remove 3):</b> ${afterDelete.join(" <-> ")}</p>
`;