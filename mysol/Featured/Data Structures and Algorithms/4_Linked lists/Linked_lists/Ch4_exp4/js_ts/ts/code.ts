/**
 * Chapter 4 – Linked List
 * Delete Node After Given Node (TS)
 */

class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

function deleteNode(prevNode: ListNode | null): void {
  if (!prevNode || !prevNode.next) {
    return;
  }

  prevNode.next = prevNode.next.next;
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
  "Chapter 4 – Linked List: Delete Node (TS)";

// Create 1 → 2 → 3 → 4
const one: ListNode = new ListNode(1);
const two: ListNode = new ListNode(2);
const three: ListNode = new ListNode(3);
const four: ListNode = new ListNode(4);

one.next = two;
two.next = three;
three.next = four;

const head: ListNode = one;

const before: number[] = traverse(head);

// Delete node 3 (prevNode is 2)
deleteNode(two);

const after: number[] = traverse(head);

(document.getElementById("output") as HTMLElement).innerHTML = `
  <p><b>Before Delete:</b> ${before.join(" → ")}</p>
  <p><b>After Delete (remove 3):</b> ${after.join(" → ")}</p>
`;