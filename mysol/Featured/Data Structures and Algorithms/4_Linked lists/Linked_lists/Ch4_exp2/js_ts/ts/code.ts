/**
 * Chapter 4 – Linked List
 * Insert Node After Given Node (TS Version)
 */

class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

function addNode(prevNode: ListNode, nodeToAdd: ListNode): void {
  nodeToAdd.next = prevNode.next;
  prevNode.next = nodeToAdd;
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
  "Chapter 4 – Linked List: Insert Node (TS)";

// Create 1 → 2 → 3
const one: ListNode = new ListNode(1);
const two: ListNode = new ListNode(2);
const three: ListNode = new ListNode(3);

one.next = two;
two.next = three;

const head: ListNode = one;

const before: number[] = traverse(head);

// Insert 99 after 2
addNode(two, new ListNode(99));

const after: number[] = traverse(head);

(document.getElementById("output") as HTMLElement).innerHTML = `
  <p><b>Before Insert:</b> ${before.join(" → ")}</p>
  <p><b>After Insert (99 after 2):</b> ${after.join(" → ")}</p>
`;