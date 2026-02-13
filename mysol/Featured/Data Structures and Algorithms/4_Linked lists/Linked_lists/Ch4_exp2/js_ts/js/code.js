/**
 * Chapter 4 – Linked List
 * Insert Node After Given Node (JS Version)
 */

class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

function addNode(prevNode, nodeToAdd) {
  nodeToAdd.next = prevNode.next;
  prevNode.next = nodeToAdd;
}

function traverse(head) {
  const values = [];
  let current = head;

  while (current !== null) {
    values.push(current.val);
    current = current.next;
  }

  return values;
}

/* ========================
   Execution
======================== */

document.getElementById("title").innerText =
  "Chapter 4 – Linked List: Insert Node (JS)";

// Create 1 → 2 → 3
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);

one.next = two;
two.next = three;

const head = one;

const before = traverse(head);

// Insert 99 after 2
addNode(two, new ListNode(99));

const after = traverse(head);

document.getElementById("output").innerHTML = `
  <p><b>Before Insert:</b> ${before.join(" → ")}</p>
  <p><b>After Insert (99 after 2):</b> ${after.join(" → ")}</p>
`;