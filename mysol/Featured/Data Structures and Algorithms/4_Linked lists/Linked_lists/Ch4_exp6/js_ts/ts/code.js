/**
 * Dummy Pointer - Doubly Linked List (TS)
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
document.getElementById("title").innerText =
    "Dummy Pointer - Doubly Linked List (TS)";
// Create nodes
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);
// Link forward
one.next = two;
two.next = three;
// Link backward
two.prev = one;
three.prev = two;
const head = one;
let output = "";
// Print list
output += "Created Doubly Linked List:<br>";
let current = head;
while (current !== null) {
    output += current.val;
    if (current.next !== null) {
        output += " <-> ";
    }
    current = current.next;
}
output += "<br><br>";
// Dummy traversal sum
let ans = 0;
let dummy = head;
while (dummy !== null) {
    ans += dummy.val;
    dummy = dummy.next;
}
output += "Sum using dummy pointer: " + ans + "<br><br>";
output += "Head still at: " + head.val;
document.getElementById("output").innerHTML = output;
