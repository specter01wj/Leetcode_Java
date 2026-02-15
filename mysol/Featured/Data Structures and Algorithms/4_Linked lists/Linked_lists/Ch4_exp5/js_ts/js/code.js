/**
 * Example 5: Doubly Linked List with Sentinel Nodes (JS)
 */

class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}

// Sentinel nodes
const head = new ListNode(-1);
const tail = new ListNode(-1);

// Initialize
head.next = tail;
tail.prev = head;

// ========================
// Operations
// ========================

function addToEnd(nodeToAdd) {
  nodeToAdd.next = tail;
  nodeToAdd.prev = tail.prev;
  tail.prev.next = nodeToAdd;
  tail.prev = nodeToAdd;
}

function removeFromEnd() {
  if (head.next === tail) {
    return;
  }

  const nodeToRemove = tail.prev;
  nodeToRemove.prev.next = tail;
  tail.prev = nodeToRemove.prev;
}

function addToStart(nodeToAdd) {
  nodeToAdd.prev = head;
  nodeToAdd.next = head.next;
  head.next.prev = nodeToAdd;
  head.next = nodeToAdd;
}

function removeFromStart() {
  if (head.next === tail) {
    return;
  }

  const nodeToRemove = head.next;
  nodeToRemove.next.prev = head;
  head.next = nodeToRemove.next;
}

// ========================
// Print
// ========================

function printList() {
  let current = head.next;

  if (current === tail) {
    return "(empty)";
  }

  const values = [];

  while (current !== tail) {
    values.push(current.val);
    current = current.next;
  }

  return values.join(" <-> ");
}

// ========================
// Execution (Same as Java)
// ========================

document.getElementById("title").innerText =
  "Sentinel Doubly Linked List (JS)";

let output = "";

output += "Initial (empty):<br>";
output += printList() + "<br><br>";

// remove on empty
removeFromStart();
removeFromEnd();

output += "After removeFromStart() & removeFromEnd() on empty:<br>";
output += printList() + "<br><br>";

// Add operations
addToStart(new ListNode(10));
output += "After addToStart(10):<br>";
output += printList() + "<br><br>";

addToEnd(new ListNode(20));
output += "After addToEnd(20):<br>";
output += printList() + "<br><br>";

addToStart(new ListNode(5));
output += "After addToStart(5):<br>";
output += printList() + "<br><br>";

addToEnd(new ListNode(30));
output += "After addToEnd(30):<br>";
output += printList() + "<br><br>";

// Remove operations
removeFromStart();
output += "After removeFromStart():<br>";
output += printList() + "<br><br>";

removeFromEnd();
output += "After removeFromEnd():<br>";
output += printList() + "<br><br>";

removeFromStart();
output += "After removeFromStart():<br>";
output += printList() + "<br><br>";

removeFromEnd();
output += "After removeFromEnd() (back to empty):<br>";
output += printList();

document.getElementById("output").innerHTML = output;