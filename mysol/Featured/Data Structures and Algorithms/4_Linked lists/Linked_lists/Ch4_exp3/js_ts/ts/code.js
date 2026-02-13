/**
 * Chapter 4 – Linked List
 * Delete Node After Given Node (TS)
 */
class ListNode {
    val;
    next;
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}
function deleteNode(prevNode) {
    if (!prevNode || !prevNode.next) {
        return;
    }
    prevNode.next = prevNode.next.next;
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
    "Chapter 4 – Linked List: Delete Node (TS)";
// Create 1 → 2 → 3 → 4
const one = new ListNode(1);
const two = new ListNode(2);
const three = new ListNode(3);
const four = new ListNode(4);
one.next = two;
two.next = three;
three.next = four;
const head = one;
const before = traverse(head);
// Delete node 3 (prevNode is 2)
deleteNode(two);
const after = traverse(head);
document.getElementById("output").innerHTML = `
  <p><b>Before Delete:</b> ${before.join(" → ")}</p>
  <p><b>After Delete (remove 3):</b> ${after.join(" → ")}</p>
`;
