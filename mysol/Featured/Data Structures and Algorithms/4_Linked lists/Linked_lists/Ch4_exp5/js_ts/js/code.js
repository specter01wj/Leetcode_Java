/**
 * Chapter 4 – Doubly Linked List
 * Insert & Delete
 */

class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}

function addNode(node, nodeToAdd) {
  const prevNode = node.prev;

  nodeToAdd.next = node;
  nodeToAdd.prev = prevNode;

  if (prevNode !== null) {
    prevNode.next = nodeToAdd;
  }

  node.prev = nodeToAdd;
}

function deleteNode(node) {
  const prevNode = node.prev;
  const nextNode = node.next;

  if (prevNode !== null) {
    prevNode.next = nextNode;
  }

  if (nextNode !== null) {
    nextNode.prev = prevNode;
  }
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
  "Chapter 4 – Doubly Linked List (JS)";

// Create 1 <-> 2 <-> 3
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);

one.next = two;
two.prev = one;

two.next = three;
three.prev = two;

const head = one;

// BEFORE
const before = traverse(head);

// Insert 99 before 2
addNode(two, new ListNode(99));
const afterInsert = traverse(head);

// Delete 3
deleteNode(three);
const afterDelete = traverse(head);

// CONSISTENT OUTPUT
document.getElementById("output").innerHTML = `
  <p><b>Initial:</b> ${before.join(" <-> ")}</p>
  <p><b>After Insert (99 before 2):</b> ${afterInsert.join(" <-> ")}</p>
  <p><b>After Delete (remove 3):</b> ${afterDelete.join(" <-> ")}</p>
`;