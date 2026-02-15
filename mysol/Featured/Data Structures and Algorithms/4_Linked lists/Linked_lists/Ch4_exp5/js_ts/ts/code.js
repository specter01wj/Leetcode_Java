/**
 * Example 5: Doubly Linked List with Sentinel Nodes (TS)
 */
class ListNode {
    val;
    next;
    prev;
    constructor(val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
const head = new ListNode(-1);
const tail = new ListNode(-1);
head.next = tail;
tail.prev = head;
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
/* ========================
   Execution (Same Flow as Java)
======================== */
document.getElementById("title").innerText =
    "Sentinel Doubly Linked List (TS)";
let output = "";
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
document.getElementById("output").innerHTML = output;
