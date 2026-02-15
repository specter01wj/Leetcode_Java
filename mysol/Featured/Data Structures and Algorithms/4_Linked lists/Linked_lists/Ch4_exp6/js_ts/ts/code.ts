/**
 * Example 5: Doubly Linked List with Sentinel Nodes (TS)
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

const head: ListNode = new ListNode(-1);
const tail: ListNode = new ListNode(-1);

head.next = tail;
tail.prev = head;

function addToEnd(nodeToAdd: ListNode): void {
  nodeToAdd.next = tail;
  nodeToAdd.prev = tail.prev;
  tail.prev!.next = nodeToAdd;
  tail.prev = nodeToAdd;
}

function removeFromEnd(): void {
  if (head.next === tail) {
    return;
  }

  const nodeToRemove: ListNode = tail.prev!;
  nodeToRemove.prev!.next = tail;
  tail.prev = nodeToRemove.prev;
}

function addToStart(nodeToAdd: ListNode): void {
  nodeToAdd.prev = head;
  nodeToAdd.next = head.next;
  head.next!.prev = nodeToAdd;
  head.next = nodeToAdd;
}

function removeFromStart(): void {
  if (head.next === tail) {
    return;
  }

  const nodeToRemove: ListNode = head.next!;
  nodeToRemove.next!.prev = head;
  head.next = nodeToRemove.next;
}

function printList(): string {
  let current: ListNode | null = head.next;

  if (current === tail) {
    return "(empty)";
  }

  const values: number[] = [];
  while (current !== tail) {
    values.push(current.val);
    current = current.next;
  }

  return values.join(" <-> ");
}

/* ========================
   Execution (Same Flow as Java)
======================== */

(document.getElementById("title") as HTMLElement).innerText =
  "Sentinel Doubly Linked List (TS)";

let output: string = "";

output += "Initial (empty):<br>";
output += printList() + "<br><br>";

removeFromStart();
removeFromEnd();

output += "After removeFromStart() & removeFromEnd() on empty:<br>";
output += printList() + "<br><br>";

addToStart(new ListNode(10));
output += "After addToStart(10):<br>" + printList() + "<br><br>";

addToEnd(new ListNode(20));
output += "After addToEnd(20):<br>" + printList() + "<br><br>";

addToStart(new ListNode(5));
output += "After addToStart(5):<br>" + printList() + "<br><br>";

addToEnd(new ListNode(30));
output += "After addToEnd(30):<br>" + printList() + "<br><br>";

removeFromStart();
output += "After removeFromStart():<br>" + printList() + "<br><br>";

removeFromEnd();
output += "After removeFromEnd():<br>" + printList() + "<br><br>";

removeFromStart();
output += "After removeFromStart():<br>" + printList() + "<br><br>";

removeFromEnd();
output += "After removeFromEnd() (back to empty):<br>" + printList();

(document.getElementById("output") as HTMLElement).innerHTML = output;